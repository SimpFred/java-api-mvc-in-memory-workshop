package com.booleanuk.api.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
    private static int nextId = 1;

    private int id;
    private String name;
    private String email;

    public Author(String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
    }

    public Author() {}
}
