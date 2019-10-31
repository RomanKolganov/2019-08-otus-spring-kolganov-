package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getById(long id);
    void save(Author author);
    void update(Author author);
    void delete(long id);
}
