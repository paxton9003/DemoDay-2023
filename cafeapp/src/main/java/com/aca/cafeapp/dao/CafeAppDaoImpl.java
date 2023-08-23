package com.aca.cafeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aca.cafeapp.model.Food;
import com.aca.cafeapp.model.FoodType;

public class CafeAppDaoImpl implements CafeAppDao{

	private static String selectAllFoodItems = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems";
	
	private static String selectFoodByFoodType = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE foodtypeId = ? ";
	
	private static String selectFoodById = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE id = ? ";
	
	private static String selectFoodByPrice = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE price = ? ";
	
	private static String selectFoodByCaffeine = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE hasCaffeine = ? ";
	
	private static String selectFoodByVegan = "SELECT menuName, foodTypeId, id, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
			+ "FROM fooditems "
			+ "WHERE isVegan = ? ";
	
	private static String deleteFoodItemById = "DELETE FROM fooditems "
			+ "WHERE id = ? ";
	
	private static String updateFoodItemById = "UPDATE fooditems "
			+ "SET menuName = ?, " // 1
			+ "foodTypeId = ?, " // 2
			+ "price = ?, " // 3
			+ "hasCaffeine = ?, " // 4
			+ "isVegan = ? " // 5
			+ "WHERE id = ? "; // 6
	
	private static String insertFoodItem = "INSERT INTO foodItems (menuName, foodTypeId, price, hasCaffeine, isVegan) "
			+ "VALUES "
			+ "(? , ? , ? , ? , ? )";
	
//	private static String selectFoodItemsByPriceRange = "SELECT menuName, foodTypeId, price, hasCaffeine, isVegan, updateDateTime, createDateTime "
//			+ "FROM fooditems "
//			+ "WHERE price >= ? "
//			+ "AND price <= ? ";
	
	
	@Override
	public List<Food> getFood() {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();
		
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(selectAllFoodItems);
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myFoodItems;
	}
	

		
	//Gets food items from the database.
	private List<Food> makeFoodItem(ResultSet result) throws SQLException {
		List<Food> myFoodItems = new ArrayList<Food>();
		
		while (result.next()) {
			Food food = new Food();
			food.setId(result.getInt("id"));
			food.setHasCaffeine(result.getBoolean("hasCaffeine"));
			food.setMenuName(result.getString("menuName"));
			food.setPrice(result.getInt("price"));
			food.setVegan(result.getBoolean("isVegan"));
			
			
			String foodTypeString = result.getString("foodTypeId");
			FoodType myFoodType = FoodType.convertStringToFoodType(foodTypeString);
			food.setFoodType(myFoodType);
			
			food.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			food.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			
			myFoodItems.add(food);
		}
		return myFoodItems;
	}

	@Override
	public List<Food> getFoodItemsByFoodType(FoodType foodType) {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectFoodByFoodType);
			ps.setString(1, foodType.toString());
			result = ps.executeQuery();
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodItems;
	}

	@Override
	public List<Food> getFoodItemsByPrice(Integer price) {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectFoodByPrice);
			ps.setInt(1, price);
			result = ps.executeQuery();
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodItems;
	}

	@Override
	public List<Food> getFoodItemsById(Integer id) {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectFoodById);
			ps.setInt(1, id);
			result = ps.executeQuery();
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodItems;
	}

	@Override
	public Food createFoodItem(Food newFood) {
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(insertFoodItem);
			ps.setString(1, newFood.getMenuName());
			ps.setString(2, newFood.getFoodType().toString());
			ps.setInt(3, newFood.getPrice());
			ps.setBoolean(4, newFood.isHasCaffeine());
			ps.setBoolean(5, newFood.isVegan());
			
			int rowCount = ps.executeUpdate();
			System.out.println("New food items created: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newFood;
	}

	@Override
	public Food deleteFoodItemById(Integer id) {
		List<Food> foodItems = getFoodItemsById(id);
		Food foodItemToDelete = null;
		
		if (foodItems.size() > 0) {
			foodItemToDelete = foodItems.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(deleteFoodItemById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return foodItemToDelete;
	}

	@Override
	public Food updateFoodItem(Food updateFood) {
		List<Food> foodItems = getFoodItemsById(updateFood.getId());
		
		
		if (foodItems.size() > 0) {
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection conn = MariaDbUtil.getConnection();
			try {
				ps = conn.prepareStatement(updateFoodItemById);
				ps.setString(1, updateFood.getMenuName());
				ps.setString(2, updateFood.getFoodType().toString());
				ps.setInt(3, updateFood.getPrice());
				ps.setInt(6, updateFood.getId());
				ps.setBoolean(4, updateFood.isHasCaffeine());
				ps.setBoolean(5, updateFood.isVegan());
				
				updateRowCount = ps.executeUpdate();
				System.out.println("rows updated: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return updateFood;
	}

	@Override
	public List<Food> getCaffeineItems(boolean hasCaffeine) {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectFoodByCaffeine);
			ps.setBoolean(1, hasCaffeine);
			result = ps.executeQuery();
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodItems;
	}
	
	@Override
	public List<Food> getVeganItems(boolean vegan) {
		List<Food> myFoodItems = new ArrayList<Food>();
		ResultSet result = null;
		PreparedStatement ps = null;
		
		Connection conn = MariaDbUtil.getConnection();
		try {
			ps = conn.prepareStatement(selectFoodByVegan);
			ps.setBoolean(1, vegan);
			result = ps.executeQuery();
			myFoodItems = makeFoodItem(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myFoodItems;
	}

}
