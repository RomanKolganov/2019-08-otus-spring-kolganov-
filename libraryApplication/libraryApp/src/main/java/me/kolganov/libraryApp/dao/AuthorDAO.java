package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDAO {
    List<Author> findAll();
    Optional<Author> findById(long id);
    Author save(Author author);
    void deleteById(long id);
}
