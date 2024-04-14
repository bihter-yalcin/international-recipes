package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
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
    public void crateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id).stream().findFirst();
    }

    @Override
    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }
}
