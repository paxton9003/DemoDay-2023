package com.aca.cafeapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.aca.cafeapp.model.Food;
import com.aca.cafeapp.model.FoodType;
import com.aca.cafeapp.service.FoodService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path ("/food")
@Produces(MediaType.APPLICATION_JSON)
public class CafeAppController {
		
	private FoodService service = new FoodService();
	
	
	@GET
	public List<Food> getFoodItems(){
		return service.getFoodItems();
	}
	
	@GET
	@Path ("/{foodTypeValue}")
	public List<Food> getFoodItemsByFoodType(@PathParam("foodTypeValue")String x){
		FoodType foodType = FoodType.convertStringToFoodType(x);
		return service.getFoodItemsByFoodType(foodType);
	}
	
	@GET
	@Path ("/price/{priceValue}")
	public List<Food> getFoodItemsByPrice(@PathParam("priceValue")Integer price){
		return service.getFoodItemsByPrice(price);
	}
	
	@GET
	@Path ("/id/{idValue}")
	public List<Food> getFoodItemsById(@PathParam("idValue")Integer id){
		return service.getFoodItemsById(id);
	}
	
	@GET
	@Path("/caffinated/{caffeineBooleanValue}")
	public List<Food> getCaffineItems(@PathParam("caffeineBooleanValue")boolean hasCaffeine){
		System.out.println(hasCaffeine);
		return service.getCaffineItems(hasCaffeine);
	}
	
	@GET
	@Path("/vegan/{veganBooleanValue}")
	public List<Food> getVeganItems(@PathParam("veganBooleanValue")boolean vegan){
		return service.getVeganItems(vegan);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Food createFoodItem(Food newFood) {
		return service.createFoodItem(newFood);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Food updateFoodItem(Food updateFood) {
		return service.updateFoodItem(updateFood);
	}
	
	@DELETE
	@Path ("/id/{idValue}")
	public Food deleteFoodItemById(@PathParam("idValue")Integer id) {
		return service.deleteFoodItemById(id);
	}
	


}
