package se.ecutb.hala.recept_database_jpa.data;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
import se.ecutb.hala.recept_database_jpa.entity.Measurement;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeIngredientRepositoryTest {
    @Autowired
    private RecipeIngredientRepository testObject;

    private RecipeIngredient recipeIngredient1;
    private RecipeIngredient recipeIngredient2;


    @BeforeEach
    void setUp() {
        recipeIngredient1 = new RecipeIngredient(new Ingredient("Potato"),1, Measurement.KG,new Recipe());
        recipeIngredient2 = new RecipeIngredient(new Ingredient("Pasta"),500,Measurement.G,new Recipe());
        testObject.save(recipeIngredient1);
        testObject.save(recipeIngredient2);
    }
    @Test
    public void save_one_recipe_ingredient(){
        RecipeIngredient result = testObject.save(new RecipeIngredient(new Ingredient("salt"),1,Measurement.TSK,new Recipe()));

        assertEquals(3,testObject.count());
        assertNotNull(result);
    }

    @Test
    public void find_by_id_recipe_ingredient(){
        Optional<RecipeIngredient> result = testObject.findById(recipeIngredient1.getRecipeIngredientId());

        assertNotNull(result);
        assertTrue(result.isPresent());

    }
}
