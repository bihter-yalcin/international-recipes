package com.playbook.internationalrecipes.service;


import com.playbook.internationalrecipes.model.dtos.recipeDtos.RecipeDTO;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
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

    public RecipeEntity createRecipe(RecipeDTO request) {
       return recipeRepository.createRecipe(RecipeEntity.create(request));
    }

    public Optional<RecipeEntity> getRecipe(Long id) {
        return recipeRepository.findById(id);
    }

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }
    public void updateRecipe(Long id, RecipeDTO updateRequest) {
        Optional<RecipeEntity> optionalRecipe = recipeRepository.findById(id);

        if (optionalRecipe.isPresent()){
            RecipeEntity recipeEntity = optionalRecipe.get();
            RecipeEntity updatedRecipeEntity = RecipeEntity.update(recipeEntity,updateRequest);
            recipeRepository.updateRecipe(updatedRecipeEntity);
        }else {
            throw new NoSuchElementException("Recipe with id " + id + " not found");
        }
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteRecipe(id);
    }

}
