package me.kolganov.libraryApp.domain;

import java.util.List;

public class Author {
    private long id;
    private String name;
    private List<Book> books;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(long id) {
        this.id = id;
    }

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
