package com.playbook.internationalrecipes.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import com.playbook.internationalrecipes.service.AuthorService;
import com.playbook.internationalrecipes.utils.TestUtils;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.playbook.internationalrecipes.utils.TestUtils.createTestAuthor1;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class AuthorControllerIntegrationTest extends PostgresTestContainerInitializer {

    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    private AuthorService authorService;

    @Autowired
    public AuthorControllerIntegrationTest(MockMvc mockMvc, ObjectMapper objectMapper, AuthorService authorService) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.authorService = authorService;
    }


    @Test
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
    public void itShouldGet200WhenGettingAuthorById() throws Exception {
       var author = authorService.createAuthor(createTestAuthor1().getName());
       var id = author.getId().toString();
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/authors/"+id)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(MockMvcResultMatchers.jsonPath("$.id").value(author.getId())
                ).andExpect(MockMvcResultMatchers.jsonPath("$.name").value("William Shakespeare"));


    }


    @Test
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
        var author = authorService.createAuthor(createTestAuthor1().getName());
        var id = author.getId().toString();
        mockMvc.perform
                        (MockMvcRequestBuilders.get("/authors")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                ).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(author.getId()));;


    }

    @Test
    public void itShouldGet200WhenUpdateAuthor() throws Exception {
        var authorWillBeUpdated = authorService.createAuthor(createTestAuthor1().getName());
        String authorObjectConvertedToString = objectMapper.writeValueAsString(authorWillBeUpdated);
        mockMvc.perform
                        (MockMvcRequestBuilders.put("/authors/"+authorWillBeUpdated.getId().toString())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(authorObjectConvertedToString))
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                );

    }

    @Test
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


    @Test
    public void itShouldGet204WhenDeleterAuthor() throws Exception {
        authorService.createAuthor(createTestAuthor1().getName());
        mockMvc.perform
                        (MockMvcRequestBuilders.delete("/authors/1")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.status().is(204)
                );

    }

}
