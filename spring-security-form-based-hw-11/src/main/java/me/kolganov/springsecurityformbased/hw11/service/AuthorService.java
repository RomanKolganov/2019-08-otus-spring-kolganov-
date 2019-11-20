package me.kolganov.springsecurityformbased.hw11.service;

import me.kolganov.springsecurityformbased.hw11.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getById(long id);
    void save(Author author);
    void update(Author author);
    void delete(long id);
}
