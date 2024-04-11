package com.playbook.internationalrecipes.service;

import com.playbook.internationalrecipes.model.author.Author;
import com.playbook.internationalrecipes.repository.AuthorRepository;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthorRepository.class);


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public void createAuthor(String name) {
        try {
            authorRepository.create(Author.create(name));
        } catch (DuplicateKeyException e) {
            //TODO ADD CUSTOM EXCEPTION
            logger.error("ERROR: An author with the same name already exists!");
        }
    }

}
