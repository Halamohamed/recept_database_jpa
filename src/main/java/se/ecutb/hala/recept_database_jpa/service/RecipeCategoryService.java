package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;

import java.util.List;

public interface RecipeCategoryService {
    @Transactional(rollbackFor = RuntimeException.class)
    RecipeCategory createAndSave(String category, List<Recipe> recipes);
}
