package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Book findById(long id);
    void create(Book book);
    void update(Book book);
    void delete(Book book);
}
