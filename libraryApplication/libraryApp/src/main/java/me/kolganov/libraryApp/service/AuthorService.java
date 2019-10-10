package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Author;

public interface AuthorService {
    String getAll();
    String getByName(String name);
    void save(Author author);
    void update(String oldName, String newName);
    void delete(String name);
}
