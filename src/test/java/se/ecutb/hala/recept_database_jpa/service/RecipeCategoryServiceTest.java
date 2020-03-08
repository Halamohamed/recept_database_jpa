package se.ecutb.hala.recept_database_jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.hala.recept_database_jpa.data.RecipeCategoryRepository;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeCategoryServiceTest {

    @Autowired private RecipeCategoryService categoryService;

    @Autowired private RecipeCategoryRepository categoryRepository;

    @Test
    public void createAndSave_recipe_category(){
        String category = "testCategory";

        RecipeCategory result = categoryService.createAndSave(category,null);
        RecipeCategory expected = categoryRepository.findById(result.getCategoryId()).get();

        assertEquals(expected.getCategory(),result.getCategory());

    }
}
