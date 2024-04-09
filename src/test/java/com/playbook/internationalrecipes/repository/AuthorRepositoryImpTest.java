package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import config.PostgresTestContainerInitializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AuthorRepositoryImpTest extends PostgresTestContainerInitializer {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AuthorRepositoryImp authorRepositoryImp;

    @Test
    void create() {
        var author = Author.builder().id("1").name("William").build();
        authorRepositoryImp.create(author);
        verify(jdbcTemplate).update(eq("INSERT INTO authors (id,name) VALUES (?,?)"), eq("1"), eq("William"));
    }
}