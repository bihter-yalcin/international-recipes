package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.model.author.Author;

import java.util.Optional;
import java.util.UUID;


public interface AuthorRepository {

    void create(Author author);

    Optional<Author> findById(UUID id);
}
