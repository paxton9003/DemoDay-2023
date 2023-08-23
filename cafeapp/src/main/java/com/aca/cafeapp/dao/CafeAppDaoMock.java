package com.aca.cafeapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.aca.cafeapp.model.Food;
import com.aca.cafeapp.model.FoodType;

public class CafeAppDaoMock implements CafeAppDao{
	
	private static List<Food> foodItems = new ArrayList<Food>();
	
	static {
		Food chocoChipCookie = new Food();
		chocoChipCookie.setFoodType(FoodType.Dessert);
		chocoChipCookie.setHasCaffeine(false);
		chocoChipCookie.setMenuName("Chocolate chip cookie");
		chocoChipCookie.setPrice(2);
		chocoChipCookie.setVegan(false);
		chocoChipCookie.setId(1);
		
		Food latte = new Food();
		latte.setFoodType(FoodType.Drink);
		latte.setHasCaffeine(true);
		latte.setMenuName("Latte");
		latte.setPrice(4);
		latte.setVegan(false);
		latte.setId(2);
		
		foodItems.add(chocoChipCookie);
		foodItems.add(latte);
	}
	
	
	@Override
	public List<Food> getFood() {
		List<Food> myFood = new ArrayList<Food>();
		myFood.addAll(foodItems);
		return myFood;
	}

	@Override
	public List<Food> getFoodItemsByFoodType(FoodType foodType) {
		List<Food> myFoodItems = new ArrayList<Food>();
		for(Food food : CafeAppDaoMock.foodItems) {
			if (food.getFoodType().equals(foodType)) {
				myFoodItems.add(food);
			}
			
		}
		return myFoodItems;
	}

	@Override
	public List<Food> getFoodItemsByPrice(Integer price) {
		List<Food> myFoodItems = new ArrayList<Food>();
		for(Food food : CafeAppDaoMock.foodItems) {
			if (food.getPrice().intValue() == price.intValue()) {
				myFoodItems.add(food);
			}
		}
		return myFoodItems;
	}

	@Override
	public List<Food> getFoodItemsById(Integer id) {
		List<Food> myFoodItems = new ArrayList<Food>();
		for(Food food : CafeAppDaoMock.foodItems) {
			if (food.getId().intValue() == id.intValue()) {
				myFoodItems.add(food);
			}
		}
		return myFoodItems;
	}

	@Override
	public Food createFoodItem(Food newFood) {
		newFood.setId(getNextFoodNumber());
		foodItems.add(newFood);
		return newFood;
	}
	
	@Override
	public Food deleteFoodItemById(Integer id) {
		List<Food> foodItems = getFoodItemsById(id);
		Food food = null;
		
		if(foodItems.size() > 0) {
			food = foodItems.get(0);
			CafeAppDaoMock.foodItems.remove(food);
		}
		return food;
	}

	private static Integer lastFoodId = 0;
	
	private Integer getNextFoodNumber() {
		return lastFoodId++;
	}

	@Override
	public Food updateFoodItem(Food updateFood) {

		for (Food food : CafeAppDaoMock.foodItems) {
			if (food.getId().intValue() == updateFood.getId().intValue()) {
				food.setFoodType(updateFood.getFoodType());
				food.setHasCaffeine(updateFood.isHasCaffeine());
				food.setMenuName(updateFood.getMenuName());
				food.setVegan(updateFood.isVegan());
				break;
			}
		}
		
		return updateFood;
	}

	@Override
	public List<Food> getCaffeineItems(boolean hasCaffeine) {
		List<Food> myFoodItems = new ArrayList<Food>();
		for(Food food : CafeAppDaoMock.foodItems) {
			if (food.isHasCaffeine() == hasCaffeine) {
				myFoodItems.add(food);
			}
		}
		return myFoodItems;
	}

	@Override
	public List<Food> getVeganItems(boolean vegan) {
			List<Food> myFoodItems = new ArrayList<Food>();
			for(Food food : CafeAppDaoMock.foodItems) {
				if (food.isVegan() == vegan) {
					myFoodItems.add(food);
				}
			}
			return myFoodItems;
		}
	
}


