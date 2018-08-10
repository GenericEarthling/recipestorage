package com.atomic.recipestorage.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	// fetch ingredient by name
	List<Ingredient> findByName(String name);
	
	// fetch ingredient by id
	// tried List, Set, and Optional does not work
	//List<Ingredient> findById(Long ingredientId);

}
