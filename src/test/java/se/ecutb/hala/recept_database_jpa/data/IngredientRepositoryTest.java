package se.ecutb.hala.recept_database_jpa.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository testObject;

    private Ingredient ingredientTest1;
    private Ingredient ingredientTest2;
    private Ingredient ingredientTest3;


    @BeforeEach
    void setUp() {
        ingredientTest1 = new Ingredient("milk");
        ingredientTest2 = new Ingredient("grade fil milk");
        ingredientTest3 = new Ingredient("cheese");
        testObject.save(ingredientTest1);
        testObject.save(ingredientTest2);
        testObject.save(ingredientTest3);
    }

    @Test
    public void find_by_name_given_1() {
        Optional<Ingredient> result = testObject.findByIngredientNameIgnoreCase("cheese") ;

       assertEquals(ingredientTest3,result.get());
       assertTrue(result.isPresent());
    }

    @Test
    public void find_by_name_given_2(){
        List<Ingredient> result = testObject.findByIngredientNameContainsIgnoreCase("Milk");

        List<Ingredient> expected = new ArrayList<>();
        expected.add(ingredientTest1);
        expected.add(ingredientTest2);

        assertNotNull(result);
        assertEquals(expected,result);
        assertTrue(result.size() == 2);
    }
}
