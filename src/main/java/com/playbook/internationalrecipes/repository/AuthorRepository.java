package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.model.author.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    void crateAuthor(Author author);

    Optional<Author> findById(Long id);

    List<Author> getAuthors();

}
