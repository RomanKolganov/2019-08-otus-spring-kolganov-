package me.kolganov.springactuator.service;

import me.kolganov.springactuator.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(long id);
    void save(Book book, long authorId, long genreId);
    void update(Book book, long authorId, long genreId);
    void delete(long id);
}
