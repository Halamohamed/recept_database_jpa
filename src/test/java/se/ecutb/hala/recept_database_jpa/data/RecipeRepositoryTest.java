package se.ecutb.hala.recept_database_jpa.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.hala.recept_database_jpa.entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository testObject;

    private Recipe recipe1;
    private Recipe recipe2;
    RecipeCategory party;
    RecipeCategory weekend;
    RecipeCategory spicy;
    RecipeCategory salad;

    @BeforeEach
    void setUp() {
        Ingredient ingredientTest1 = new Ingredient("milk");
        Ingredient ingredientTest2 = new Ingredient("grade fil milk");
        Ingredient ingredientTest3 = new Ingredient("potato");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredientTest1,2, Measurement.DL,new Recipe());
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredientTest2,3,Measurement.MSK,new Recipe());
        RecipeIngredient recipeIngredient3 = new RecipeIngredient(ingredientTest3,500,Measurement.G,new Recipe());
        recipe1 = new Recipe("rice",new ArrayList<>(Arrays.asList(recipeIngredient1,recipeIngredient3)),null, null);
        recipe2 = new Recipe("chicken with rice",new ArrayList<>(Arrays.asList(recipeIngredient1,recipeIngredient2)),null,null);
        party = new RecipeCategory("party",new ArrayList<>());
        weekend = new RecipeCategory("weekend",new ArrayList<>());
        spicy = new RecipeCategory("spicy",new ArrayList<>());
        salad = new RecipeCategory("salad",new ArrayList<>());



        recipe1.setCategories(new ArrayList<>(Arrays.asList(party,spicy,salad)));
        recipe2.setCategories(new ArrayList<>(Arrays.asList(party,weekend,spicy)));

        testObject.save(recipe1);
        testObject.save(recipe2);
    }

    @Test
    void find_recipe_name_by_string_given_2() {
        String name = "Rice";
        assertEquals(recipe1,testObject.findByRecipeNameContainsIgnoreCase(name).get(0));
        assertTrue(testObject.findByRecipeNameContainsIgnoreCase(name).size() == 2);
        assertNotNull(testObject);
    }

    @Test
    void find_all_recipe_contain_ingredient_name() {
        String ingredientName = "milk";
        assertNotNull(testObject.findByRecipeIngredientsIngredientIngredientName(ingredientName));

    }

    @Test
    void find_all_recipe_by_recipe_category() {
        String category = "party";

        assertEquals(2,testObject.findByCategoriesCategoryIgnoreCase(category).size());
        assertNotNull(testObject.findByCategoriesCategoryIgnoreCase(category));
    }

    @Test
    void find_all_recipe_by_list_category() {
       List<String> categoryList = Arrays.asList("party","spice");

       assertNotNull(testObject.findByCategoriesCategoryIn(categoryList));
       assertEquals(2,testObject.findByCategoriesCategoryIn(categoryList).size());

    }
}
