package com.aca.cafeapp.model;

public enum FoodType {
	Dessert, Drink, Breakfast;
	
	public static FoodType convertStringToFoodType(String value) {
		FoodType myFoodType = null;
		
		for (FoodType foodType : FoodType.values()) {
		if	(foodType.toString().equalsIgnoreCase(value)) {
			myFoodType = foodType;
			break;
			}
		}
		return myFoodType;
	}

}
