package com.aca.cafeapp.service;

import java.util.List;

import com.aca.cafeapp.dao.CafeAppDao;
import com.aca.cafeapp.dao.CafeAppDaoImpl;
import com.aca.cafeapp.model.Food;
import com.aca.cafeapp.model.FoodType;

public class FoodService {
	
	private CafeAppDao cafeAppDao = new CafeAppDaoImpl();
	
	public List<Food> getFoodItems(){
		return cafeAppDao.getFood();
	}
	
	public List<Food> getFoodItemsByFoodType(FoodType foodType){
		return cafeAppDao.getFoodItemsByFoodType(foodType);
	}

	public List<Food> getFoodItemsByPrice(Integer price) {
		return cafeAppDao.getFoodItemsByPrice(price);
	}
	
	public List<Food> getFoodItemsById(Integer id){
		return cafeAppDao.getFoodItemsById(id);
	}
	
	public List<Food> getCaffineItems(boolean hasCaffeine) {
		return cafeAppDao.getCaffeineItems(hasCaffeine);
	}
	
	public List<Food> getVeganItems(boolean vegan) {
		return cafeAppDao.getVeganItems(vegan);
	}

	public Food createFoodItem(Food newFood) {
		return cafeAppDao.createFoodItem(newFood);
	}
	
	public Food deleteFoodItemById(Integer id) {
		return cafeAppDao.deleteFoodItemById(id);
	}
	

	public Food updateFoodItem(Food updateFood) {
//		For validation later on 
//		updateFood.getFoodType();
//		updateFood.getId();
//		updateFood.getMenuName();
//		updateFood.getPrice();
		
		List<Food> foodItems = getFoodItemsById(updateFood.getId());
		if (foodItems.size() == 1) {
			return cafeAppDao.updateFoodItem(updateFood);
		} else {
			// no food item to be updated
		}
		
		return null;
	}



	

	
	
}

