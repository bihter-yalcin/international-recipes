package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    void createRecipe(RecipeEntity recipeEntity);

    Optional<RecipeEntity> findById(Long id);

    List<RecipeEntity> getAllRecipes();

    void updateRecipe(RecipeEntity recipeEntity);

    void deleteRecipe(Long id);
}
