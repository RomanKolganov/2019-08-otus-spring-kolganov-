package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Author;

public interface AuthorService {
    String getAll();
    String getById(String id);
    void save(Author author);
    void update(String id, String newName);
    void delete(String id);
}
