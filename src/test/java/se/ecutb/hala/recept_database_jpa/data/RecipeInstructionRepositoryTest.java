package se.ecutb.hala.recept_database_jpa.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class RecipeInstructionRepositoryTest {

    @Autowired
    private RecipeInstructionRepository testObject;

    private RecipeInstruction recipeInstruction;

    @BeforeEach
    void setUp() {
        recipeInstruction = new RecipeInstruction("test instruction");
        testObject.save(recipeInstruction);
    }

    @Test
    void save_one_recipe_instruction() {
        RecipeInstruction result = testObject.save(new RecipeInstruction("instruction1"));

        assertEquals(2,testObject.count());
        assertNotNull(result);
    }
}
