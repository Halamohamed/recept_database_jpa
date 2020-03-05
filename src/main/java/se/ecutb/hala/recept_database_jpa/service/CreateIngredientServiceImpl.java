package se.ecutb.hala.recept_database_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ecutb.hala.recept_database_jpa.data.IngredientRepository;
import se.ecutb.hala.recept_database_jpa.entity.Ingredient;

import java.util.Arrays;
import java.util.Objects;

@Service
public class CreateIngredientServiceImpl implements CreateIngredientService {

    private IngredientRepository ingredientRepository;

    @Autowired
    public CreateIngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional
    public Ingredient createAndSave(String ingredientName) {
        if(hasNull(ingredientName)){
            throw new RuntimeException("Ingredient name is null");
        }
        if(ingredientRepository.findByIngredientNameIgnoreCase(ingredientName).isPresent()){
            throw new RuntimeException("Ingredient name is already exist");
        }
        return ingredientRepository.save(new Ingredient(ingredientName));
    }

    public static boolean hasNull(Object... objects) {
        return Arrays.stream(objects)
                .anyMatch(obj -> Objects.isNull(obj));
    }
}
