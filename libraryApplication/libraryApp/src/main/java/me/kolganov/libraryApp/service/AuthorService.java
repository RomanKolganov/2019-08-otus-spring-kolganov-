package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Author;

public interface AuthorService {
    String getAll();
    String getById(long id);
    void save(Author author);
    void delete(long id);
}
