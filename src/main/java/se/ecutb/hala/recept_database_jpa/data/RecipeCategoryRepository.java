package se.ecutb.hala.recept_database_jpa.data;

import org.springframework.data.repository.CrudRepository;
import se.ecutb.hala.recept_database_jpa.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory,Integer> {
}
