package com.aca.cafeapp.model;

import java.time.LocalDateTime;

public class Food {
	private String menuName;
	private Integer price;
	private boolean hasCaffeine;
	private boolean isVegan;
	private FoodType foodType;
	private Integer id;
	private LocalDateTime updateDateTime;
	private LocalDateTime createDateTime;
	
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public boolean isHasCaffeine() {
		return hasCaffeine;
	}
	public void setHasCaffeine(boolean hasCaffeine) {
		this.hasCaffeine = hasCaffeine;
	}
	public boolean isVegan() {
		return isVegan;
	}
	public void setVegan(boolean isVegan) {
		this.isVegan = isVegan;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

}
