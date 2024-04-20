package com.playbook.internationalrecipes.service;

import com.playbook.internationalrecipes.exceptions.DuplicateAuthorException;
import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import com.playbook.internationalrecipes.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public void createAuthor(String name) throws DuplicateAuthorException {
        try {
            authorRepository.createAuthor(AuthorEntity.create(name));
        } catch (Exception e) {
            logger.error("ERROR: An author with the name: " + name + " already exists!");
            throw new DuplicateAuthorException("An author with the name: " + name + " already exists!");
        }
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public Optional<AuthorEntity> getAuthor(Long id) {
        return authorRepository.findById(id);
    }

    public void updateAuthor(Long id, AuthorDTO authorUpdateDTO) {
        Optional<AuthorEntity> optionalAuthor = authorRepository.findById(id);

        if (optionalAuthor.isPresent()) {
            AuthorEntity authorEntity = optionalAuthor.get();
            AuthorEntity updatedAuthorEntity = AuthorEntity.update(authorEntity, authorUpdateDTO);
            authorRepository.updateAuthor(updatedAuthorEntity);
        } else {
            throw new NoSuchElementException("Author with id " + id + " not found");
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }

}
