package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Author;

public interface AuthorService {
    String getAll();
    String getById(long id);
    void create(String name);
    void update(Author author);
    void delete(long id);
}
