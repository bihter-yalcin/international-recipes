package com.playbook.internationalrecipes.utils;

import com.playbook.internationalrecipes.model.author.Author;
import com.playbook.internationalrecipes.model.recipe.Recipe;

import java.util.List;

public class TestUtils {

    public static Author createTestAuthor1() {
        return Author.builder().id(1L).name("William Shakespeare").build();
    }

    public static Author createTestAuthor2() {
        return Author.builder().id(2L).name("Lev Tolstoy").build();
    }

    public static Author createTestAuthor3() {
        return Author.builder().id(5L).name("Pascal").build();
    }

    public static Author createTestAuthor4() {
        return Author.builder().id(6L).name("Henry").build();
    }

    public static Recipe createRecipe1() {
        return Recipe.builder().id(3L).name("Tomato Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter")).author(createTestAuthor3()).build();
    }

    public static Recipe createRecipe2() {
        return Recipe.builder().id(4L).name("Pesto Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).author(createTestAuthor4()).build();
    }

    public static Recipe updatedRecipe2(){
            return Recipe.builder().id(4L).name("Cheese Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).author(createTestAuthor4()).build();
    }
}
