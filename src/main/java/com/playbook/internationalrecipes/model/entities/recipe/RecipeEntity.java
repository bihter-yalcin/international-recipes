package com.playbook.internationalrecipes.model.entities.recipe;

import com.playbook.internationalrecipes.model.dtos.recipeDtos.RecipeDTO;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
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
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "recipe_id_seq")
    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String country;
    private Integer prepTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

    public static RecipeEntity create(RecipeDTO createRequest) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(createRequest.getName());
        recipeEntity.setDescription(createRequest.getDescription());
        recipeEntity.setIngredients(createRequest.getIngredients());
        recipeEntity.setInstructions(createRequest.getInstructions());
        recipeEntity.setCountry(createRequest.getCountry());
        recipeEntity.setPrepTime(createRequest.getPrepTime());

        return recipeEntity;
    }

    public static RecipeEntity update(RecipeEntity recipeEntity, RecipeDTO updateRecipeDto) {
        recipeEntity.setName(updateRecipeDto.getName());
        recipeEntity.setDescription(updateRecipeDto.getDescription());
        recipeEntity.setIngredients(updateRecipeDto.getIngredients());
        recipeEntity.setInstructions(updateRecipeDto.getInstructions());
        recipeEntity.setCountry(updateRecipeDto.getCountry());
        recipeEntity.setPrepTime(updateRecipeDto.getPrepTime());
        return recipeEntity;
    }
}
