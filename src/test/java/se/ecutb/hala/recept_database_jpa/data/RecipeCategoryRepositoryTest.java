package se.ecutb.hala.recept_database_jpa.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeCategoryRepositoryTest {

    @Autowired
    private RecipeCategoryRepository testObject;

    RecipeCategory recipeCategory1;
    RecipeCategory recipeCategory2;


    @BeforeEach
    void setUp() {
        recipeCategory1 = new RecipeCategory("fest",null);
        recipeCategory2 = new RecipeCategory("helg",null);
        testObject.save(recipeCategory1);
        testObject.save(recipeCategory2);
    }

    @Test
    public void save_one_recipe_category() {
        Optional<RecipeCategory> categoryTest = Optional.of(new RecipeCategory("vegetable",null));
        RecipeCategory result = testObject.save(categoryTest.get());

        assertEquals(categoryTest,testObject.findById(categoryTest.get().getCategoryId()));
        assertNotNull(result.getCategoryId());
        assertTrue(testObject.count() == 3);
    }
    @Test
    public void delete_recipe_category(){

       testObject.delete(recipeCategory1);
       assertEquals(1,testObject.count());

    }


}
