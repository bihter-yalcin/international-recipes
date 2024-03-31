package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.recipe.Recipe;

public interface RecipeRepository {
    public void create(Recipe recipe);
}
