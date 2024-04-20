package com.playbook.internationalrecipes.utils;

import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;

import java.util.List;

public class TestUtils {

    public static AuthorEntity createTestAuthor1() {
        return AuthorEntity.builder().id(1L).name("William Shakespeare").build();
    }

    public static AuthorEntity createTestAuthor2() {
        return AuthorEntity.builder().id(2L).name("Lev Tolstoy").build();
    }

    public static AuthorEntity createTestAuthor3() {
        return AuthorEntity.builder().id(5L).name("Pascal").build();
    }

    public static AuthorEntity createTestAuthor4() {
        return AuthorEntity.builder().id(6L).name("Henry").build();
    }
    public static AuthorEntity createTestAuthor5() {
        return AuthorEntity.builder().id(7L).name("Milly").build();
    }

    public static RecipeEntity createRecipe1() {
        return RecipeEntity.builder().id(3L).name("Tomato Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter")).authorEntity(createTestAuthor3()).build();
    }

    public static RecipeEntity createRecipe2() {
        return RecipeEntity.builder().id(4L).name("Pesto Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).authorEntity(createTestAuthor4()).build();
    }

    public static RecipeEntity updatedRecipe2(){
            return RecipeEntity.builder().id(4L).name("Cheese Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).authorEntity(createTestAuthor4()).build();
    }
}
