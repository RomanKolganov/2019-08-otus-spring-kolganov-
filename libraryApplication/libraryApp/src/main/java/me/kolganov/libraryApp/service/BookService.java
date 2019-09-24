package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Book;

public interface BookService {
    String getAll();
    String getById(long id);
    void create(Book book);
    void updateName(Book book);
    void updateAuthor(Book book);
    void updateGenre(Book book);
    void delete(long id);
}
