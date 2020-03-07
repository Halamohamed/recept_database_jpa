package se.ecutb.hala.recept_database_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.*;
import se.ecutb.hala.recept_database_jpa.service.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLine implements CommandLineRunner {

    private CreateIngredientService ingredientService;
    private CreateRecipeService recipeService;
    private RecipeInstructionService instructionService;
    private RecipeIngredientService recipeIngredientService;
    private RecipeCategoryService categoryService;

    List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    List<Recipe> mainRecipes = new ArrayList<>();
    List<RecipeCategory> categories = new ArrayList<>();


    @Autowired
    public CommandLine(CreateIngredientService ingredientService, CreateRecipeService recipeService, RecipeInstructionService instructionService, RecipeIngredientService recipeIngredientService, RecipeCategoryService categoryService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.instructionService = instructionService;
        this.recipeIngredientService = recipeIngredientService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        addIngredient();
        addRecipeIngredient();
        addRecipeCategory();
        addInstruction();
        addRecipe();

    }

    public void addRecipeIngredient(){
        Ingredient ingredient1 = new Ingredient("chicken");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1,500, Measurement.G,null);
        recipeIngredients.add(recipeIngredient1);
    }
    public void addInstruction(){
        String instruction = "test instruction";
        instructionService.createAndSave(instruction);
    }

    public void addRecipe(){
        String recipeName = "Fried chicken";
        RecipeInstruction instruction = new RecipeInstruction("Cut the whole chickens into 4 breasts, 4 thighs, 4 legs and 4 wings and set aside. Preheat your oil, " +
                "in either a heavy pan on the stove or a deep-fryer, to 325 degrees F. In a large bowl, combine the flour, salt, black pepper, garlic powder," +
                " onion powder and cayenne pepper until thoroughly mixed");

        recipeService.createAndSave(recipeName,recipeIngredients,instruction,categories);
    }
    public void addIngredient(){
        String ingredientName = "onion";
        System.out.println(ingredientService.createAndSave(ingredientName));
    }
    public void addRecipeCategory(){
        String category = "Main Dishes";
        RecipeCategory mainDishes = new RecipeCategory(category,mainRecipes);
        categoryService.createAndSave(category,mainRecipes);

    }
}
