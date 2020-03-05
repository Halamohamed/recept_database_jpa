package se.ecutb.hala.recept_database_jpa.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class RecipeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String category;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
    )
    @JoinTable(
            name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")
    )
    private List<Recipe> recipes;

    public RecipeCategory(int categoryId, String category, List<Recipe> recipes) {
        this.categoryId = categoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory(String category, List<Recipe> recipes) {
        this(0,category,recipes);
    }

    public RecipeCategory() { }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RecipeCategory{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", category='").append(category).append('\'');
        sb.append(", recipes=").append(recipes);
        sb.append('}');
        return sb.toString();
    }
}
