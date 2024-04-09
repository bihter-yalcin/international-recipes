package com.playbook.internationalrecipes.repository;


import com.playbook.internationalrecipes.model.author.Author;
import org.springframework.stereotype.Repository;


public interface AuthorRepository {

    public void create(Author author);
}
