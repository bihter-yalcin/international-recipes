package com.playbook.internationalrecipes.repository;

import com.playbook.internationalrecipes.model.author.Author;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<Author> findById(UUID id) {
        List<Author> authors = jdbcTemplate.query("SELECT id, name FROM authors WHERE id = ? LIMIT 1",
                new AuthorMapper(), id);

        return authors.stream().findFirst();
    }

    public static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(UUID.fromString(rs.getString("id")));
            author.setName(rs.getString("name"));
            return author;
        }
    }
}
