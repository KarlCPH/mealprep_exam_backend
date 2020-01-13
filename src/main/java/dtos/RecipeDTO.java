package dtos;

import entities.RecipeEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipeDTO {

    private String id;
    private String description;
    private String prep_time;
    private String prep;
    private String preparation_steps;
    private String ingredients;

    public RecipeDTO(){
    }

    public RecipeDTO(RecipeEntity recipeEntity) {
        this.description = recipeEntity.getDescription();
        this.prep_time = recipeEntity.getPrep_time();
        this.prep = recipeEntity.getPrep();
        this.preparation_steps = recipeEntity.getPreparation_steps();
        this.ingredients = recipeEntity.getIngredients();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeDTO)) return false;
        RecipeDTO recipeDTO = (RecipeDTO) o;
        return prep_time == recipeDTO.prep_time &&
                Objects.equals(ingredients, recipeDTO.ingredients) &&
                Objects.equals(prep, recipeDTO.prep) &&
                Objects.equals(preparation_steps, recipeDTO.preparation_steps) &&
                Objects.equals(description, recipeDTO.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash( ingredients, prep_time, description, prep, preparation_steps);
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "name='" + '\'' +
                ", ingredients=" + ingredients +
                ", prepTime=" + prep_time +
                ", prep=" + prep +
                ", preparation_steps=" + preparation_steps +
                ", description='" + description + '\'' +
                '}';
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(String prep_time) {
        this.prep_time = prep_time;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getPreparation_steps() {
        return preparation_steps;
    }

    public void setPreparation_steps(String preparation_steps) {
        this.preparation_steps = preparation_steps;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
