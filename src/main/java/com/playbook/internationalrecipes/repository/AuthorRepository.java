package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    AuthorEntity createAuthor(AuthorEntity authorEntity);

    Optional<AuthorEntity> findById(Long id);

    List<AuthorEntity> getAllAuthors();

    void updateAuthor(AuthorEntity authorEntity);

    void deleteAuthor(Long id);

    Boolean isExistById(Long id);

}
