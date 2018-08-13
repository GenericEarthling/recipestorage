package com.atomic.recipestorage.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// to include queries, add this annotation
@RepositoryRestResource
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	// fetch ingredient by name
	List<Ingredient> findByName(@Param("name") String name);
	
	// fetch ingredient by id
	//Optional<Ingredient> findById(@Param("ingredientId") Long ingredientId);

	// using SQL statements with annotation
	@Query("select i from Ingredient i where i.ingredientId = ?1")
	List<Ingredient> findByIngredientId(@Param("ingredientId") Long ingredientId);
}
