package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Comparator;

import static com.playbook.internationalrecipes.utils.TestUtils.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeEntityRepositoryAdapterIT extends PostgresTestContainerInitializer {

    @Autowired
    RecipeRepositoryAdapter recipeRepositoryAdapter;
    @Autowired
    AuthorRepositoryAdapter authorRepositoryAdapter;

    @Test
    @Order(1)
    void itShouldCreateRecipe() {

        var recipe1 = createRecipe1();
        recipeRepositoryAdapter.createRecipe(recipe1);

        var result = recipeRepositoryAdapter.findById(recipe1.getId());
        Assertions.assertThat(result.isPresent()).isEqualTo(true);
        Assertions.assertThat(result.get()).isEqualTo(recipe1);

    }

    @Test
    @Order(2)
    void itShouldRetrieveRecipeById() {
        var recipe2 = createRecipe2();
        recipeRepositoryAdapter.createRecipe(recipe2);

        var result = recipeRepositoryAdapter.findById(recipe2.getId());
        Assertions.assertThat(result.isPresent()).isEqualTo(true);
        Assertions.assertThat(result.get()).isEqualTo(recipe2);

    }

    @Test
    @Order(3)
    void itShouldRetrieveAllRecipes() {
        var result = recipeRepositoryAdapter.getAllRecipes().stream()
                .sorted(Comparator.comparing(RecipeEntity::getId))
                .toList();

        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(3L);
        Assertions.assertThat(result.get(1).getId()).isEqualTo(4L);
    }

    @Test
    @Order(4)
    void itShouldUpdateRecipe() {
        var updatedRecipe = updatedRecipe2();
        recipeRepositoryAdapter.updateRecipe(updatedRecipe);
        var result = recipeRepositoryAdapter.findById(updatedRecipe.getId());

        Assertions.assertThat(result.get()).isEqualTo(updatedRecipe);
    }

    @Test
    @Order(5)
    void itShouldDeleteRecipe() {
        recipeRepositoryAdapter.deleteRecipe(3L);
        var result = recipeRepositoryAdapter.getAllRecipes();

        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(4L);
    }
}