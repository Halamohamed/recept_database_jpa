package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;

public interface CreateIngredientService {
    @Transactional(rollbackFor = RuntimeException.class)
    Ingredient createAndSave(String IngredientName);
}
