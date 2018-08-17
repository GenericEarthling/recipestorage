package com.atomic.recipestorage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.atomic.recipestorage.domain.Ingredient;
import com.atomic.recipestorage.domain.IngredientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IngredientRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Test
	public void saveIngredient() {
		Ingredient ingredient = new Ingredient("pumpkin", 60.0, 20.0, 10.0, 0.0, 0.0, 20.0, 0.0, 0.0, 30.0, "tablespoon");
		entityManager.persistAndFlush(ingredient);
		assertThat(ingredient.getIngredientId()).isNotNull();
	}
	
	@Test
	public void deleteIngredient() {
		entityManager.persistAndFlush(new Ingredient("oats", 0.5, 150.0, 10.0, 0.0, 0.0, 50.0, 0.0, 0.0, 30.0, "cup"));
		entityManager.persistAndFlush(new Ingredient("flax seed", 0.5, 150.0, 10.0, 0.0, 0.0, 50.0, 0.0, 0.0, 30.0, "teaspoon"));
		ingredientRepository.deleteAll();
		assertThat(ingredientRepository.findAll()).isEmpty();
	}
}
