package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.model.author.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    void createAuthor(Author author);

    Optional<Author> findById(Long id);

    List<Author> getAllAuthors();

    void updateAuthor(Author author);

    void deleteAuthor(Long id);

}
