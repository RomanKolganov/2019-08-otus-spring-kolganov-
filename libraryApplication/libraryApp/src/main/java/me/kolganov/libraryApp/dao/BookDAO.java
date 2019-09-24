package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book findById(long id);
    void create(Book book);
    void updateName(Book book);
    void updateAuthor(Book book);
    void updateGenre(Book book);
    void deleteById(long id);
}
