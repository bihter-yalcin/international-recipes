package com.playbook.internationalrecipes.utils;

import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
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
        return AuthorEntity.builder().id(3L).name("Henry").build();
    }
    public static AuthorDTO createTestAuthor5() {
        return AuthorDTO.builder().id(7L).name("John").build();
    }

    public static RecipeEntity createRecipe1() {
        return RecipeEntity.builder().id(1L).name("Tomato Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter")).authorEntity(createTestAuthor1()).build();
    }

    public static RecipeEntity createRecipe2() {
        return RecipeEntity.builder().id(2L).name("Pesto Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).authorEntity(createTestAuthor3()).build();
    }

    public static RecipeEntity createRecipe3() {
        return RecipeEntity.builder().id(3L).name("Creamy Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).authorEntity(createTestAuthor1()).build();
    }
    public static RecipeEntity updatedRecipe2(){
            return RecipeEntity.builder().id(2L).name("Cheese Pasta").country("Italy").description("Wash Tomatos").
                prepTime(30).ingredients(List.of("tomato", "butter", "pesto")).authorEntity(null).build();
    //TODO NULL AUTHOR
    }
}
