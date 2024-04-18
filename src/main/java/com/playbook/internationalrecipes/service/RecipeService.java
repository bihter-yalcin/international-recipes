package com.playbook.internationalrecipes.service;


import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeCreateRequest;
import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeUpdateRequest;
import com.playbook.internationalrecipes.model.recipe.Recipe;
import com.playbook.internationalrecipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void createRecipe(RecipeCreateRequest request) {
        recipeRepository.createRecipe(Recipe.create(request));
    }

    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
    public void updateRecipe(Long id, RecipeUpdateRequest updateRequest) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);

        if (optionalRecipe.isPresent()){
            Recipe recipe = optionalRecipe.get();
            Recipe updatedRecipe = Recipe.update(recipe,updateRequest);
            recipeRepository.updateRecipe(updatedRecipe);
        }else {
            throw new NoSuchElementException("Recipe with id " + id + " not found");
        }
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteRecipe(id);
    }

}
