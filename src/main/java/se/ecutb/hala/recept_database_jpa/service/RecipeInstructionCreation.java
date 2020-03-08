package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.data.RecipeInstructionRepository;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

import static se.ecutb.hala.recept_database_jpa.service.CreateIngredientServiceImpl.hasNull;

@Service
public class RecipeInstructionCreation implements RecipeInstructionService {

    private RecipeInstructionRepository instructionRepository;

    @Autowired
    public RecipeInstructionCreation(RecipeInstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstruction createAndSave(String instruction) {
        if(hasNull(instruction)){
            throw new RuntimeException("Instruction can not be null");
        }
        RecipeInstruction recipeInstruction = instructionRepository.save(new RecipeInstruction(instruction));

        return recipeInstruction;
    }
}
