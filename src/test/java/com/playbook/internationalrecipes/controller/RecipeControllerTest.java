package com.playbook.internationalrecipes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.entities.recipe.RecipeEntity;
import com.playbook.internationalrecipes.utils.TestUtils;
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
@SpringBootTest
public class RecipeControllerTest extends PostgresTestContainerInitializer {

    //TODO Make Controller Test can be run separately
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @Autowired
    public RecipeControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
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

        mockMvc.perform
                        (MockMvcRequestBuilders.get("/recipes/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(jsonPath("$.id").value(1)
                ).andExpect(jsonPath("$.name").value("Tomato Pasta"));


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

        mockMvc.perform
                        (MockMvcRequestBuilders.get("/recipes")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(jsonPath("$[0].id").value(1)
                ).andExpect(jsonPath("$[0].name").value("Tomato Pasta"));


    }


}
