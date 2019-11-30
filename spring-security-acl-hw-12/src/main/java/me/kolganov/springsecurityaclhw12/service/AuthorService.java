package me.kolganov.springsecurityaclhw12.service;

import me.kolganov.springsecurityaclhw12.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author getById(long id);
    void save(Author author);
    void update(Author author);
    void delete(long id);
}
