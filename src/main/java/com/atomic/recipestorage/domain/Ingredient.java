/**
 * ingredient amt and measure should NOT be saved to the ingredient database
 */
package com.atomic.recipestorage.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ingredientId;
	private String name;	
	private double servingSize;	
	private double calories;	
	private double fat;	
	private double cholesterol;	
	private double sodium;
	private double carbohydrates;
	private double fiber;
	private double protein;
	private double ingredAmt;
	private String measure;
	
	// many recipes to one ingredient
	// fetch defines the strategy for fetching data from the database
	// LAZY means that when the recipe is fetched, all the ingredients 
	//    associated with it will be fetched ONLY when needed.
	// EAGER means data will be fetched immediately with the recipe
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="recipe") 
	private Recipe recipe;
	
	public Ingredient() {}
	
	public Ingredient(String name, double servingSize, double calories, double fat, double cholesterol, double sodium,
			double carbohydrates, double fiber, double protein, double ingredAmt, String measure, Recipe recipe) {
		super();
		this.name = name;
		this.servingSize = servingSize;
		this.calories = calories;
		this.fat = fat;
		this.cholesterol = cholesterol;
		this.sodium = sodium;
		this.carbohydrates = carbohydrates;
		this.fiber = fiber;
		this.protein = protein;
		this.ingredAmt = ingredAmt;
		this.measure = measure;
		this.recipe = recipe;
	}

	
	public Ingredient(String name, double servingSize, double calories, double fat, double cholesterol, double sodium,
		double carbohydrates, double fiber, double protein, double ingredAmt, String measure) {
	super();
	this.name = name;
	this.servingSize = servingSize;
	this.calories = calories;
	this.fat = fat;
	this.cholesterol = cholesterol;
	this.sodium = sodium;
	this.carbohydrates = carbohydrates;
	this.fiber = fiber;
	this.protein = protein;
	this.ingredAmt = ingredAmt;
	this.measure = measure;
}
	
	public Recipe getRecipe() {
		return recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getServingSize() {
		return servingSize;
	}

	public void setServingSize(double servingSize) {
		this.servingSize = servingSize;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getIngredAmt() {
		return ingredAmt;
	}

	public void setIngredAmt(double ingredAmt) {
		this.ingredAmt = ingredAmt;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	@Override
	public String toString() {
		return "Ingredient [Id=" + ingredientId + ", name=" + name + ", servingSize=" + servingSize
				+ ", calories=" + calories + ", fat=" + fat + ", cholesterol=" + cholesterol + ", sodium=" + sodium
				+ ", carbohydrates=" + carbohydrates + ", fiber=" + fiber + ", protein=" + protein + ", ingredAmt="
				+ ingredAmt + ", measure=" + measure + ", Recipe=" + recipe + "]";
	}	
	
	

}
