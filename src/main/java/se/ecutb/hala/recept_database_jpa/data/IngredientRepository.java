package se.ecutb.hala.recept_database_jpa.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    //Hitta en ingrediens med specifikt ingrediensnamn.
    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);

    //Hitta flera ingredienser vars ingrediensnamn innehåller en viss String.
    List<Ingredient> findByIngredientNameContainsIgnoreCase(String name);


}
