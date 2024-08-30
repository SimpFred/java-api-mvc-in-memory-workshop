package com.booleanuk.api.controllers;

import com.booleanuk.api.model.Author;
import com.booleanuk.api.repositories.AuthorsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorsRepository theAuthors;

    public AuthorController() {
        this.theAuthors = new AuthorsRepository();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Author> getAll() {
        return this.theAuthors.getAll();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getOne(@PathVariable int id) {
        return this.theAuthors.getOne(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@PathVariable int id, @RequestBody Author author) {
        Author updatedAuthor = this.theAuthors.update(id, author);
        if (updatedAuthor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");
        }
        this.theAuthors.update(id, author);
        return author;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        this.theAuthors.create(author);
        return author;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author remove(@PathVariable int id) {
        return this.theAuthors.remove(id);
    }

}
