package com.atomic.recipestorage;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atomic.recipestorage.domain.Ingredient;
import com.atomic.recipestorage.domain.IngredientRepository;
import com.atomic.recipestorage.domain.Recipe;
import com.atomic.recipestorage.domain.RecipeRepository;

@SpringBootApplication
public class RecipeStorageApplication {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	public static void main(String[] args) {
		SpringApplication.run(RecipeStorageApplication.class, args);
		System.out.println("All Systems Go! - by Rin & Stempy");
	}
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Ingredient sugar = new Ingredient("sugar", 30.0, 120.0, 0.0, 0.0, 0.0, 30.0, 0.0, 0.0, 30.0, "grams");
			Ingredient milk = new Ingredient("milk", 30.0, 120.0, 0.0, 0.0, 0.0, 30.0, 0.0, 0.0, 30.0, "grams"); 
			Ingredient flour = new Ingredient("flour", 30.0, 120.0, 0.0, 0.0, 0.0, 30.0, 0.0, 0.0, 30.0, "grams");
			// add ingred to repository
			ingredientRepository.save(sugar);
			ingredientRepository.save(milk);
			ingredientRepository.save(flour);
			// add ingred to a set
			Set<Ingredient> pieIngredients = new HashSet<>();
			pieIngredients.add(flour);
			pieIngredients.add(milk);
			pieIngredients.add(sugar);
			
			Set<Ingredient> cakeIngredients = new HashSet<>();
			cakeIngredients.add(flour);
			cakeIngredients.add(sugar);
			
			// create recipe object
			Recipe pieRecipe = new Recipe("Sugar Pie", "Good for eating", pieIngredients);
			Recipe cakeRecipe = new Recipe("Chocolate Cake", "Cake-Chocula");
			//cakeRecipe.setIngredients(cakeIngredients);
			recipeRepository.save(pieRecipe);
			recipeRepository.save(cakeRecipe).setIngredients(cakeIngredients);
			
			// Doesn't make sense to add the recipe to the Ingredient objects/database
			Recipe cookieRecipe = new Recipe("Peanut Butter Cookie","Eat the cookie dough");
			Ingredient egg = new Ingredient("egg", 30.0, 120.0, 0.0, 0.0, 0.0, 30.0, 0.0, 0.0, 30.0, "grams");
			egg.setRecipe(cookieRecipe);
			recipeRepository.save(cookieRecipe);
			System.out.println(egg.toString());
			
			// print to console
			System.out.println(pieRecipe.toString());
			System.out.println(cakeRecipe.toString());
			
		};   
	} 
}
