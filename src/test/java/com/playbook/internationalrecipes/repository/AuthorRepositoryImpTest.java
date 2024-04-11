package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import config.PostgresTestContainerInitializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

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
        var id = UUID.randomUUID();
        var author = Author.builder().id(id).name("William").build();
        authorRepositoryImp.create(author);
        verify(jdbcTemplate).update(eq("INSERT INTO authors (id,name) VALUES (?,?)"), eq(id), eq("William"));
    }
}