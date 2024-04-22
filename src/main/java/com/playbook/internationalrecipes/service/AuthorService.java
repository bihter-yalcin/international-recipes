package com.playbook.internationalrecipes.service;

import com.playbook.internationalrecipes.exceptions.DuplicateAuthorException;
import com.playbook.internationalrecipes.exceptions.IdNotFoundException;
import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import com.playbook.internationalrecipes.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthorRepository.class);


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public AuthorEntity createAuthor(String name) {
        try {
            return authorRepository.createAuthor(AuthorEntity.create(name));
        } catch (Exception e) { //TODO ADD SPECIFIC EXCEPTION
            logger.error("ERROR: An author with the name: " + name + " already exists!");
            throw new DuplicateAuthorException("An author with the name: " + name + " already exists!");
        }
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public Optional<AuthorEntity> getAuthor(Long id) {
        if (checkForIsIdExist(id)) {
            return authorRepository.findById(id);
        } else throw new IdNotFoundException("Author with id " + id + " not found");
    }

    public void updateAuthor(Long id, AuthorDTO authorUpdateDTO) {
        if (checkForIsIdExist(id)) {
            AuthorEntity updatedAuthorEntity = AuthorEntity.update(authorRepository.findById(id).get(), authorUpdateDTO);
            authorRepository.updateAuthor(updatedAuthorEntity);
        } else {
            throw new IdNotFoundException("Author with id " + id + " not found");
        }
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }

    private Boolean checkForIsIdExist(Long id) {
        return authorRepository.isExistById(id);
    }

}
