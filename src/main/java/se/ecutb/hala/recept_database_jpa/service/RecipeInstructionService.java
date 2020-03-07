package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.RecipeInstruction;

public interface RecipeInstructionService {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeInstruction createAndSave(String instruction);
}
