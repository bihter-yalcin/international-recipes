package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.recipe.Recipe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepositoryAdapter implements RecipeRepository {

    private final PostgresDbRecipeRepository recipeRepository;

    public RecipeRepositoryAdapter(PostgresDbRecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void createRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id).stream().findFirst();
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

}
