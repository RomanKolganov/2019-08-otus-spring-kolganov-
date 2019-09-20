package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Book;

import java.util.List;

public interface BookService {
    String getAll();
    String getById(long id);
    void create(Book book);
    void update(Book book);
    void delete(Book book);
}
