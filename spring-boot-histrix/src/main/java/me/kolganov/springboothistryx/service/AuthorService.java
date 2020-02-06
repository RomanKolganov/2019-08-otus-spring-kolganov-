package me.kolganov.springboothistryx.service;

import me.kolganov.springboothistryx.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getById(long id);
    void save(Author author);
    void update(Author author);
    void delete(long id);
}
