package com.playbook.internationalrecipes.service;

import com.playbook.internationalrecipes.model.author.Author;
import com.playbook.internationalrecipes.repository.AuthorRepository;
import com.playbook.internationalrecipes.repository.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService( AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public void createAuthor(String name) {
        authorRepository.create(new Author(name));
    }

}
