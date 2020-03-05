package se.ecutb.hala.recept_database_jpa.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe,Integer> {

    //Hitta flera recept vars receptnamn innehåller en viss String.
    List<Recipe> findByRecipeNameContainsIgnoreCase(String recipeName);

    //Hitta alla recept som innehåller ett visst ingrediensnamn.
    List<Recipe> findByRecipeIngredientsIngredientIngredientName(String ingredientName);

    //Hitta alla recept som tillhör en viss receptkategori.
    List<Recipe> findByCategoriesCategoryIgnoreCase(String category);

    //Hitta alla recept som har en eller flera träffar från en samling kategorier.
    //List<Recipe> findByCategoriesCategory(List<String> category);
}
