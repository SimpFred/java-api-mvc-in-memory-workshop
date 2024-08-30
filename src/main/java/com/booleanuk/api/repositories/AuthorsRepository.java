package com.booleanuk.api.repositories;

import com.booleanuk.api.model.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Getter
@Setter
public class AuthorsRepository {
    private ArrayList<Author> authors;

    public AuthorsRepository() {
        authors = new ArrayList<>();

        authors.add(new Author("John Doe", "John@doe.com"));
        authors.add(new Author("Jane Doe", "Jane@doe.com"));
    }

    public ArrayList<Author> getAll() {
        return this.authors;
    }

    public Author getOne(int id) {
        return this.authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void create(Author author) {
        this.authors.add(author);
    }

    public Author update(int id, Author author) {
        Author authorToUpdate = getOne(id);
        if (authorToUpdate != null) {
            authorToUpdate.setName(author.getName());
            authorToUpdate.setEmail(author.getEmail());
            return authorToUpdate;
        }

        return null;
    }

    public Author remove(int id) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId() == id) {
                return authors.remove(i);
            }
        }
        return null;
    }
}
