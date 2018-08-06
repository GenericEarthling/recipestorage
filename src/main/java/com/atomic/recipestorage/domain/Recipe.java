package com.atomic.recipestorage.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long recipeId;
	private String name;
	private String notes;
	
	// recipe may have many ingredients
	// cascade defines how cascading affects the entities.
	//     ALL means that if the recipe is deleted, the ingredients linked to 
	//         the recipe will be deleted
	//     DETACH might be better, but for now...
	// mappedBy=recipe means the Ingredient class has the 'recipe' field, it's the foreign key
	// orphanRemoval=false means if a recipe is removed, it will NOT remove ingredient from db
	@OneToMany(cascade=CascadeType.DETACH, mappedBy="recipe", orphanRemoval=false)
	@JsonIgnore
	private Set<Ingredient> ingredients;
	
	public Recipe() {}



	public Recipe(String name, String notes) {
	super();
	this.name = name;
	this.notes = notes;
}

	


	public Recipe(String name, String notes, Set<Ingredient> ingredients) {
		super();
		this.name = name;
		this.notes = notes;
		this.ingredients = ingredients;
	}



	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}



	

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		String result = String.format("Recipe: id=%d, name='%s', notes='%s']%n",
                recipeId, name, notes);
		if (ingredients != null)
			for(Ingredient ingredient : ingredients) {
				result += String.format(
                        "Ingredient[id=%d, name='%s']%n",
                        ingredient.getIngredientId(), ingredient.getName());
			}
		return result;
	}
	
	
	
}
