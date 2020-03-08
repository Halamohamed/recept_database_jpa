package se.ecutb.hala.recept_database_jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.hala.recept_database_jpa.data.RecipeRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
import se.ecutb.hala.recept_database_jpa.entity.Measurement;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@AutoConfigureTestDatabase
public class CreateRecipeServiceTest {

    @Autowired private CreateRecipeService recipeService;
    @Autowired private RecipeRepository repository;
    Ingredient ingredient1 = new Ingredient("salad");

    @Test
    public void createAndSave_test_recipe(){
        List<RecipeIngredient> recipeIngredients = new ArrayList<>(Arrays.asList(new RecipeIngredient(ingredient1,2, Measurement.ST,null)));
        Recipe actual = recipeService.createAndSave("testRecipe",recipeIngredients,null,null);
        Recipe recipe = repository.findByRecipeNameContainsIgnoreCase("testRecipe").get(0);

        assertEquals(recipe.getRecipeName(),actual.getRecipeName());

    }


}
