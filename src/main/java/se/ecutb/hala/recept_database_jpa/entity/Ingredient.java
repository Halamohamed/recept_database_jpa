package se.ecutb.hala.recept_database_jpa.entity;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientId;
    @Column(unique = true)
    private String ingredientName;

    public Ingredient(int ingredientId, String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public Ingredient(String ingredientName) {
        this(0,ingredientName);
    }

    public Ingredient() { }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingredient{");
        sb.append("ingredientId=").append(ingredientId);
        sb.append(", ingredientName='").append(ingredientName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
