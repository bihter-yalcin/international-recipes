package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import config.PostgresTestContainerInitializer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Testcontainers
@ActiveProfiles("test")
class AuthorRepositoryAdapterIntegrationTest extends PostgresTestContainerInitializer {

    @Autowired
    AuthorRepositoryAdapter authorRepositoryAdapter;


    @Test
    @Order(value = 1)
    void testCreateMethod() {
        var author = Author.builder().name("William").build();
        authorRepositoryAdapter.createAuthor(author);
        Optional<Author> result = authorRepositoryAdapter.findById(author.getId());
        assert result.isPresent();
        assert result.get().equals(author);
    }

    @Test
    @Order(value = 2)
    void findById() {
        var author = Author.builder().name("Hello").build();
        authorRepositoryAdapter.createAuthor(author);
        List<Author> result = authorRepositoryAdapter.getAllAuthors();
        var a =  result.get(0).getId();
    }

    @Test
    void getAuthors() {
    }
}