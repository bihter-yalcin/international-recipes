package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.recipe.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;

public class RecipeRepositoryImp implements RecipeRepository {
    private JdbcTemplate jdbcTemplate;

    public RecipeRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Recipe recipe) {
        jdbcTemplate.update("INSERT INTO recipes (name,description,ingredients,instructions,country,prepTime,author_id) VALUES (?,?,?,?,?,?,?)");

    }
}
