package com.playbook.internationalrecipes.model.recipe;

import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeCreateRequest;
import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeUpdateRequest;
import com.playbook.internationalrecipes.model.author.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public static Recipe create(RecipeCreateRequest createRequest) {
        Recipe recipe = new Recipe();
        recipe.setName(createRequest.getName());
        recipe.setDescription(createRequest.getDescription());
        recipe.setIngredients(createRequest.getIngredients());
        recipe.setInstructions(createRequest.getInstructions());
        recipe.setCountry(createRequest.getCountry());
        recipe.setPrepTime(createRequest.getPrepTime());

        return recipe;
    }

    public static Recipe update(Recipe recipe, RecipeUpdateRequest updateRequest) {
        recipe.setName(updateRequest.getName());
        recipe.setDescription(updateRequest.getDescription());
        recipe.setIngredients(updateRequest.getIngredients());
        recipe.setInstructions(updateRequest.getInstructions());
        recipe.setCountry(updateRequest.getCountry());
        recipe.setPrepTime(updateRequest.getPrepTime());
        return recipe;
    }
}
