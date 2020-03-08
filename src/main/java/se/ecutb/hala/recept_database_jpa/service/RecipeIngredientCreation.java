package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.data.RecipeIngredientRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
import se.ecutb.hala.recept_database_jpa.entity.Measurement;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;

import static se.ecutb.hala.recept_database_jpa.service.CreateIngredientServiceImpl.hasNull;

@Service
public class RecipeIngredientCreation implements RecipeIngredientService {

    private RecipeIngredientRepository ingredientRepository;

    @Autowired
    public RecipeIngredientCreation(RecipeIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient createAndSave(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        if (hasNull(ingredient,amount,measurement)){
          throw new RuntimeException("one or more parameter is null");
        }
        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,amount,measurement,recipe);

        return ingredientRepository.save(recipeIngredient);
    }
}
