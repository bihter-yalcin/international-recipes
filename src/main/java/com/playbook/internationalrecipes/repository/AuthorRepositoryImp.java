package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import org.springframework.jdbc.core.JdbcTemplate;

public class AuthorRepositoryImp implements AuthorRepository {

    private JdbcTemplate jdbcTemplate;

    public AuthorRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors (name) VALUES (?)"); //TODO WHAT ABOUT ID?

    }
}
