package entities;

import dtos.IngredientsDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
//@NamedQuery(name = "RecipeEntity.getAllRows", query = "SELECT Recipe FROM RecipeEntity Recipe")
@Table(name = "recipeentity")
public class RecipeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "description")
    private String description;
    @Column(name = "prep_time")
    private String prep_time;
    @Column(name = "prep")
    private String prep;
    @Column(name = "preparation_steps")
    private String preparation_steps;

    public String getIngredients() {
        return ingredients;
    }

    private String ingredients;


    public RecipeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    public RecipeEntity(Long id, String prep_time, String prep, String preparation_steps, String ingredients) {
        this.id = id;
        this.prep_time = prep_time;
        this.prep = prep;
        this.preparation_steps = preparation_steps;
        this.ingredients = ingredients;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String directions) {
        this.description = directions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeEntity)) return false;
        RecipeEntity recipe = (RecipeEntity) o;
        return prep_time == recipe.getPrep_time() &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(description, recipe.description) &&
                Objects.equals(prep_time, recipe.prep_time) &&
                Objects.equals(preparation_steps, recipe.preparation_steps) &&
                Objects.equals(prep, recipe.prep);

    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients, description, prep_time, preparation_steps, prep);
    }
}
