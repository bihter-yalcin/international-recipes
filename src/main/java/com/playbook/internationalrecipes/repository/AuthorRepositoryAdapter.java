package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryAdapter implements AuthorRepository {

    private final PostgresDbAuthorRepository authorRepository;

    public AuthorRepositoryAdapter(PostgresDbAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public Optional<AuthorEntity> findById(Long id) {
        return authorRepository.findById(id).stream().findFirst();
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void updateAuthor(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
