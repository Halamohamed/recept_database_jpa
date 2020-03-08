package se.ecutb.hala.recept_database_jpa.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class RecipeInstructionServiceTest {
    @Autowired
    private RecipeInstructionService instructionService;

    @Test
    public void createAndSave_recipe_instruction(){
        String instruction = "test instruction";
        RecipeInstruction result = instructionService.createAndSave(instruction);

        assertNotNull(result.getInstructionId());
        assertTrue(result.getInstructions().equals(instruction));
    }

}
