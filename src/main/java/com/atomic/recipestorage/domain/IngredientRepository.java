package com.atomic.recipestorage.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	// fetch ingredient by name
	List<Ingredient> findByName(String name);

}
