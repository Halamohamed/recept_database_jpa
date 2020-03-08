package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;
@Repository
public interface CreateIngredientService {
    @Transactional
    Ingredient createAndSave(String IngredientName);
}
