package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
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
    public void createRecipe(RecipeEntity recipeEntity) {
        recipeRepository.save(recipeEntity);
    }

    @Override
    public Optional<RecipeEntity> findById(Long id) {
        return recipeRepository.findById(id).stream().findFirst();
    }

    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public void updateRecipe(RecipeEntity recipeEntity) {
        recipeRepository.save(recipeEntity);
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

}
