package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeUpdateRequest;
import com.playbook.internationalrecipes.model.recipe.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    void createRecipe(Recipe recipe);

    Optional<Recipe> findById(Long id);

    List<Recipe> getAllRecipes();

    void updateRecipe(RecipeUpdateRequest updateRequest);

    void deleteRecipe(Long id);
}
