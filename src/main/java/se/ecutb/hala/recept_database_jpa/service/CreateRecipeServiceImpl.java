package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.data.RecipeRepository;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;
import se.ecutb.hala.recept_database_jpa.entity.RecipeIngredient;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

import java.util.List;

import static se.ecutb.hala.recept_database_jpa.service.CreateIngredientServiceImpl.hasNull;
@Service
public class CreateRecipeServiceImpl implements CreateRecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public CreateRecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        Recipe recipe = recipeRepository.save(new Recipe(recipeName, recipeIngredients, instruction, categories));

        if(hasNull(recipeName,recipeIngredients,instruction,categories)){
            throw new RuntimeException("One or more parameter is null");
        }
        /*
        if(recipeRepository.findByRecipeNameContainsIgnoreCase(recipeName).stream().findFirst().isPresent()){
            throw new RuntimeException("This recipe name is already exist");
        }
        */


        return recipe;
    }
}
