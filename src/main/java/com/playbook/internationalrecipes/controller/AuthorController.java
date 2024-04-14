package com.playbook.internationalrecipes.controller;

import com.playbook.internationalrecipes.model.author.Author;
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

    @PostMapping("/authorCreate")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(String name) {
        authorService.createAuthor(name);
    }
    @GetMapping("/{id}")
    public Optional<Author> getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
