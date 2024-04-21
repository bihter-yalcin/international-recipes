package com.playbook.internationalrecipes.controller;

import com.playbook.internationalrecipes.model.dtos.authorDtos.AuthorDTO;
import com.playbook.internationalrecipes.model.entities.author.AuthorEntity;
import com.playbook.internationalrecipes.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorEntity createAuthor(@RequestBody AuthorDTO createDTO) {
        return authorService.createAuthor(createDTO.getName());
    }

    @GetMapping("/{id}")
    public Optional<AuthorEntity> getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO updateDto) {
        authorService.updateAuthor(id, updateDto);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
