package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import config.PostgresTestContainerInitializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorRepositoryImpIntegrationTest extends PostgresTestContainerInitializer {

    @Autowired
    private AuthorRepositoryImp authorRepositoryImp;

    @Test
    void testCreateMethod() {
        var author = Author.builder().id(UUID.randomUUID()).name("William").build();
        authorRepositoryImp.create(author);
        Optional<Author> result = authorRepositoryImp.findById(author.getId());
        assert result.isPresent();
        assert result.get().equals(author);
    }
}