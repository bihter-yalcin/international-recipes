package com.playbook.internationalrecipes.service;


import com.playbook.internationalrecipes.exceptions.IdNotFoundException;
import com.playbook.internationalrecipes.model.dtos.recipeDtos.RecipeDTO;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
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

    public RecipeEntity createRecipe(RecipeDTO request) {
        return recipeRepository.createRecipe(RecipeEntity.create(request));
    }

    public Optional<RecipeEntity> getRecipe(Long id) {
        Optional<RecipeEntity> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            return recipeRepository.findById(id);
        } else {
            throw new IdNotFoundException("Recipe with id " + id + " not found");
        }
    }

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public void updateRecipe(Long id, RecipeDTO updateRequest) {
        Optional<RecipeEntity> optionalRecipe = recipeRepository.findById(id);

        if (optionalRecipe.isPresent()) {
            RecipeEntity recipeEntity = optionalRecipe.get();
            RecipeEntity updatedRecipeEntity = RecipeEntity.update(recipeEntity, updateRequest);
            recipeRepository.updateRecipe(updatedRecipeEntity);
        } else {
            throw new IdNotFoundException("Recipe with id " + id + " not found");
        }
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteRecipe(id);
    }

}
