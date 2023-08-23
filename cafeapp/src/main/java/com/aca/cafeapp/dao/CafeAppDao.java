package com.aca.cafeapp.dao;

import java.util.List;

import com.aca.cafeapp.model.Food;
import com.aca.cafeapp.model.FoodType;

public interface CafeAppDao {
	public List<Food> getFood();
	public List<Food> getFoodItemsByFoodType(FoodType foodType);
	public List<Food> getFoodItemsByPrice(Integer price);
	public List<Food> getFoodItemsById(Integer id);
	public Food createFoodItem(Food newFood);
	public Food deleteFoodItemById(Integer id);
	public Food updateFoodItem(Food updateFood);
	public List<Food> getCaffeineItems(boolean hasCaffine);
	public List<Food> getVeganItems(boolean vegan);
	

}
