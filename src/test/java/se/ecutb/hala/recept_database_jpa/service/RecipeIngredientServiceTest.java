package se.ecutb.hala.recept_database_jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.hala.recept_database_jpa.data.RecipeIngredientRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
import se.ecutb.hala.recept_database_jpa.entity.Measurement;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeIngredientServiceTest {

   @Autowired
   private RecipeIngredientService ingredientService;

   @Test
   public void createAndSave_recipe_ingredient(){
       Ingredient ingredient = new Ingredient("pasta");
       RecipeIngredient result = ingredientService.createAndSave(ingredient,500, Measurement.G,null);

       assertNotNull(result.getIngredient().getIngredientName());
       assertTrue(result.getIngredient().getIngredientName().equals("pasta"));
   }
}
