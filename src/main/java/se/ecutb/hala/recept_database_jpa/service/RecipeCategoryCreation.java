package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.data.RecipeCategoryRepository;
import se.ecutb.hala.recept_database_jpa.entity.Recipe;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;

import java.util.List;

import static se.ecutb.hala.recept_database_jpa.service.CreateIngredientServiceImpl.hasNull;
@Service
public class RecipeCategoryCreation implements RecipeCategoryService {

    private RecipeCategoryRepository categoryRepository;

    @Autowired
    public RecipeCategoryCreation(RecipeCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory createAndSave(String category, List<Recipe> recipes) {
        if(hasNull(category)){
            throw new RuntimeException("Category must not be null");
        }

        RecipeCategory recipeCategory = categoryRepository.save(new RecipeCategory(category,recipes));
        return recipeCategory;
    }
}
