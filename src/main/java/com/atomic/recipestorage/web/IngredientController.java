package com.atomic.recipestorage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atomic.recipestorage.domain.Ingredient;
import com.atomic.recipestorage.domain.IngredientRepository;

@RestController
public class IngredientController {
	
	// inject the ingredient repository into the controller so
	//  I can use the findAll method to get/fetch all ingredients
	@Autowired
	private IngredientRepository ingredientRepository;
	
	// The /end-point the method is mapped to
	// returns all the ingredient objects which are then 
	//   marshalled to JSON objects by Jackson library
	@RequestMapping("/ingredients")
	public Iterable<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}

}
