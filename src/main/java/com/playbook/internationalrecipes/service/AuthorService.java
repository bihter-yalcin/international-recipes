package com.playbook.internationalrecipes.service;

import com.playbook.internationalrecipes.model.Requests.AuthorRequests.AuthorUpdateRequest;
import com.playbook.internationalrecipes.model.author.Author;
import com.playbook.internationalrecipes.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthorRepository.class);


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public void createAuthor(String name) {
        try {
            authorRepository.createAuthor(Author.create(name));
        } catch (DuplicateKeyException e) {
            //TODO ADD CUSTOM EXCEPTION
            logger.error("ERROR: An author with the same name already exists!");
        }
    }

    public List<Author> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public Optional<Author> getAuthor(Long id) {
        return authorRepository.findById(id);
    }

    public void updateAuthor(Long id, AuthorUpdateRequest request) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            Author updatedAuthor = Author.update(author, request);
            authorRepository.updateAuthor(updatedAuthor);
        } else {
            throw new NoSuchElementException("Author with id " + id + " not found");
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }

}
