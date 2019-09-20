package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> findAll();
    Author findById(long id);
    void create(Author author);
    void update(Author author);
    void deleteById(long id);
}
