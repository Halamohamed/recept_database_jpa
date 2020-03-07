package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
import se.ecutb.hala.recept_database_jpa.entity.Measurement;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;

public interface RecipeIngredientService {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeIngredient createAndSave(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe);
}
