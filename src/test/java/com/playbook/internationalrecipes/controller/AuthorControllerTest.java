package com.playbook.internationalrecipes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import com.playbook.internationalrecipes.utils.TestUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class AuthorControllerTest {

    //TODO Make Controller Test can be run separately
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @Autowired
    public AuthorControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }


    @Test
    @Order(1)
    public void itShouldCreateAuthor() throws Exception {
        AuthorDTO author = TestUtils.createTestAuthor5();
        String authorObjectConvertedToString = objectMapper.writeValueAsString(author);


        mockMvc.perform
                        (MockMvcRequestBuilders.post("/authors")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().isCreated()
                ).andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber()
                ).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));


    }

    @Test
    @Order(2)
    public void itShouldGet200WhenGettingAuthorById() throws Exception {
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/authors/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L)
                ).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("William Shakespeare"));


    }


    @Test
    @Order(3)
    public void itShouldGet404WhenGettingNonExistAuthor() throws Exception {
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/authors/555")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().is(404)
                );

    }

    @Test
    public void itShouldGet200WhenGettingAuthors() throws Exception {
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/authors")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(3L)
                ).andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Henry"));


    }

    @Test
    @Order(4)
    public void itShouldGet200WhenUpdateAuthor() throws Exception {
        AuthorDTO author = TestUtils.createTestAuthor1DTO();
        String authorObjectConvertedToString = objectMapper.writeValueAsString(author);
        mockMvc.perform
                        (MockMvcRequestBuilders.put("/authors/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );

    }

    @Test
    @Order(5)
    public void itShouldGet404WhenUpdatingNonExistAuthor() throws Exception {
        AuthorDTO author = TestUtils.createTestAuthor1DTO();
        author.setId(77L);
        String authorObjectConvertedToString = objectMapper.writeValueAsString(author);
        mockMvc.perform
                        (MockMvcRequestBuilders.put("/authors/77")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().is(404));


    }
}
