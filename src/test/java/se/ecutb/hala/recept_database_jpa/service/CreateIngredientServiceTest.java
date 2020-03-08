package se.ecutb.hala.recept_database_jpa.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.hala.recept_database_jpa.data.IngredientRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class CreateIngredientServiceTest {

    @Autowired
    private CreateIngredientService ingredientService;
    @Autowired
    private IngredientRepository ingredientRepository;

    Ingredient ingredient1;

    @Test
    public void find_ingredient_by_ingredient_name() {
        String ingredientName = "Test";
        Ingredient actualIngredient = ingredientService.createAndSave(ingredientName);
        String expect = ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).get().getIngredientName();
        assertEquals(expect, actualIngredient.getIngredientName());
    }
}
