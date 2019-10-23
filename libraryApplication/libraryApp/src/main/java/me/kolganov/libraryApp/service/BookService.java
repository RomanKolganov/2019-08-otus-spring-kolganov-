package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Book;

public interface BookService {
    String getAll();
    String getById(String id);
    void save(Book book, String authorId, String genreId);
    void save(Book book);
    void delete(String id);
}
