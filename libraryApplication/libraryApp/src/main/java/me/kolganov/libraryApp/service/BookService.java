package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Book;

public interface BookService {
    String getAll();
    String getById(long id);
    void save(Book book, long authorId, long genreId);
    void save(Book book);
    void updateAuthor(Book book);
    void updateGenre(Book book);
    void delete(long id);
}
