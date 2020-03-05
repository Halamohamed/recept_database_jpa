package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

import java.util.List;

public interface CreateRecipeService {
    @Transactional(rollbackFor = RuntimeException.class)
    Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories);
}
