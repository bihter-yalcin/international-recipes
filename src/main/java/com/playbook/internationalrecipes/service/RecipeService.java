package com.playbook.internationalrecipes.service;


import com.playbook.internationalrecipes.model.Requests.RecipeRequests.RecipeCreateRequest;
import com.playbook.internationalrecipes.model.recipe.Recipe;
import com.playbook.internationalrecipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void createRecipe(RecipeCreateRequest request) {
        var recipe = new Recipe();
        //TODO Recipe.create
        recipeRepository.createRecipe(recipe);
    }

    public Optional<Recipe> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteRecipe(id);
    }

}
