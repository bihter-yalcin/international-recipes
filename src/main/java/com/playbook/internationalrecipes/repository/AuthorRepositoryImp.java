package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImp implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;

    public AuthorRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (id,name) VALUES (?,?)", author.getId(), author.getName());
    }
}
