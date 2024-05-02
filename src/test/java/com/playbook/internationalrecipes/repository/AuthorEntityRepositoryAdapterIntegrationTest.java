package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.config.PostgresTestContainerInitializer;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorEntityRepositoryAdapterIntegrationTest extends PostgresTestContainerInitializer {

    @Autowired
    AuthorRepositoryAdapter authorRepositoryAdapter;


    @Test
    void itShouldCreateAuthor() {
        var author1 = createTestAuthor1();
        authorRepositoryAdapter.createAuthor(author1);
        Optional<AuthorEntity> result = authorRepositoryAdapter.findById(author1.getId());
        assert result.isPresent();
        assert result.get().equals(author1);
    }

    @Test
    void itShouldReturnAuthorById() {
        var author2 = createTestAuthor2();
        authorRepositoryAdapter.createAuthor(author2);
        Optional<AuthorEntity> result = authorRepositoryAdapter.findById(author2.getId());
        assert result.isPresent();
        assert result.get().equals(author2);
    }

    @Test
    void itShouldRetrieveAuthors() {
        var author1 = createTestAuthor1();
        var firstAuthor = authorRepositoryAdapter.createAuthor(author1);
        var author2 = createTestAuthor2();
        var secondAuthor = authorRepositoryAdapter.createAuthor(author2);

        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors().stream()
                .sorted(Comparator.comparing(AuthorEntity::getId))
                .toList();
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(firstAuthor.getId());
        Assertions.assertThat(result.get(1).getId()).isEqualTo(secondAuthor.getId());
    }

    @Test
    void itShouldUpdateAuthor() {
        var author2 = createTestAuthor2();
        var secondAuthor = authorRepositoryAdapter.createAuthor(author2);

        var newAuthorName = "George Orwell";
         secondAuthor.setName(newAuthorName);

        authorRepositoryAdapter.updateAuthor(secondAuthor);
        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors().stream()
                .sorted(Comparator.comparing(AuthorEntity::getId))
                .toList();

        Assertions.assertThat(result.size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getId()).isEqualTo(secondAuthor.getId());
        Assertions.assertThat(result.get(0).getName()).isEqualTo(newAuthorName);
    }

    @Test
    void itShouldDeleteAuthor() {
        var author1 = createTestAuthor1();
        var firstAuthor = authorRepositoryAdapter.createAuthor(author1);

        authorRepositoryAdapter.deleteAuthor(author1.getId());
        List<AuthorEntity> result = authorRepositoryAdapter.getAllAuthors();
        Assertions.assertThat(result.size()).isEqualTo(0);
    }

}