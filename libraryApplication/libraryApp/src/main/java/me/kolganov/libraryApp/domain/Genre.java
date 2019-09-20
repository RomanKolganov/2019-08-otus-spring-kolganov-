package me.kolganov.libraryApp.domain;

import java.util.List;

public class Genre {
    private long id;
    private String name;
    private List<Book> books;

    public Genre(long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
