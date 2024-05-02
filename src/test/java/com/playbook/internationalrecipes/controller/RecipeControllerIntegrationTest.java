package com.playbook.internationalrecipes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.dtos.recipeDtos.RecipeDTO;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
import com.playbook.internationalrecipes.service.RecipeService;
import com.playbook.internationalrecipes.utils.TestUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class RecipeControllerIntegrationTest extends PostgresTestContainerInitializer {

    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    private RecipeService recipeService;

    @Autowired
    public RecipeControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper,RecipeService recipeService) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.recipeService = recipeService;
    }


    @Test
    public void itShouldCreateRecipe() throws Exception {
        RecipeEntity recipe = TestUtils.createRecipe3();
        String recipeObjectConvertedToString = objectMapper.writeValueAsString(recipe);

        mockMvc.perform
                        (MockMvcRequestBuilders.post("/recipes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().isCreated()
                ).andExpect(jsonPath("$.id").isNumber()
                ).andExpect(jsonPath("$.name").value("Creamy Pasta"));


    }

    @Test
    public void itShouldGet200WhenGettingRecipeById() throws Exception {
        RecipeDTO recipe = TestUtils.createRecipe1Dto();
        var createdRecipe = recipeService.createRecipe(recipe);
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/recipes/"+createdRecipe.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(jsonPath("$.id").value(createdRecipe.getId())
                ).andExpect(jsonPath("$.name").value("Spicy Pasta"));


    }

    @Test
    public void itShouldGet404WhenGettingNonExistRecipe() throws Exception {

        mockMvc.perform
                        (MockMvcRequestBuilders.get("/recipes/555")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().is(404));

        //TODO Add message check

    }


    @Test
    public void itShouldGet200WhenGettingRecipes() throws Exception {
        RecipeDTO recipe = TestUtils.createRecipe1Dto();
        var createdRecipe = recipeService.createRecipe(recipe);
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/recipes")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(jsonPath("$[0].id").value(createdRecipe.getId())
                ).andExpect(jsonPath("$[0].name").value("Spicy Pasta"));


    }

    @Test
    public void itShouldGet200WhenUpdateRecipe() throws Exception {
        RecipeDTO recipe = TestUtils.createRecipe1Dto();
        var createdRecipe = recipeService.createRecipe(recipe);

        String recipeObjectConvertedToString = objectMapper.writeValueAsString(recipe);
        mockMvc.perform
                        (MockMvcRequestBuilders.put("/recipes/"+createdRecipe.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );

    }

    @Test
    public void itShouldGet404WhenUpdatingNonExistRecipe() throws Exception {
        RecipeDTO recipe = TestUtils.createRecipe1Dto();
        recipe.setId(77L);
        String recipeObjectConvertedToString = objectMapper.writeValueAsString(recipe);
        mockMvc.perform
                        (MockMvcRequestBuilders.put("/recipes/77")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().is(404));


    }

    @Test
    public void itShouldGet204WhenDeleterRecipe() throws Exception {
        RecipeDTO recipe = TestUtils.createRecipe1Dto();
        var createdRecipe = recipeService.createRecipe(recipe);
        mockMvc.perform
                        (MockMvcRequestBuilders.delete("/recipes/"+createdRecipe.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().is(204)
                );

    }


}
