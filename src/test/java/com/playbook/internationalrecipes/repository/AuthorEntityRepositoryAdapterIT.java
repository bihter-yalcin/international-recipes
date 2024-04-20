package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
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
import java.util.List;
import java.util.Optional;

import static com.playbook.internationalrecipes.utils.TestUtils.createTestAuthor1;
import static com.playbook.internationalrecipes.utils.TestUtils.createTestAuthor2;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AuthorEntityRepositoryAdapterIT extends PostgresTestContainerInitializer {

    @Autowired
    AuthorRepositoryAdapter authorRepositoryAdapter;


    @Test
    @Order(1)
    void itShouldCreateAuthor() {
        var author1 = createTestAuthor1();
        authorRepositoryAdapter.createAuthor(author1);
        Optional<AuthorEntity> result = authorRepositoryAdapter.findById(author1.getId());
        assert result.isPresent();
        assert result.get().equals(author1);
    }

    @Test
    @Order(2)
    void itShouldReturnAuthorById() {
        var author2 = createTestAuthor2();
        authorRepositoryAdapter.createAuthor(author2);
        Optional<AuthorEntity> result = authorRepositoryAdapter.findById(author2.getId());
        assert result.isPresent();
        assert result.get().equals(author2);
    }

    @Test
    @Order(3)
    void itShouldRetrieveAuthors() {
        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors().stream()
                .sorted(Comparator.comparing(AuthorEntity::getId))
                .toList();
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(1L);
        Assertions.assertThat(result.get(1).getId()).isEqualTo(2L);
    }

    @Test
    @Order(value = 4)
    void itShouldUpdateAuthor() {
        var newAuthorName = "George Orwell";
        var updatedAuthor = createTestAuthor2();
        updatedAuthor.setName(newAuthorName);
        authorRepositoryAdapter.updateAuthor(updatedAuthor);
        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors().stream()
                .sorted(Comparator.comparing(AuthorEntity::getId))
                .toList();
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(1).getId()).isEqualTo(2L);
        Assertions.assertThat(result.get(1).getName()).isEqualTo(newAuthorName);
    }

    @Test
    @Order(value = 5)
    void itShouldDeleteAuthor() {
        authorRepositoryAdapter.deleteAuthor(2L);
        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors();
        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(1L);
    }

}