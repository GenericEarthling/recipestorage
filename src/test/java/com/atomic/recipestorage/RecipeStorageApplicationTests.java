package com.atomic.recipestorage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import com.atomic.recipestorage.web.IngredientController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeStorageApplicationTests {
	
	@Autowired
	private IngredientController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
