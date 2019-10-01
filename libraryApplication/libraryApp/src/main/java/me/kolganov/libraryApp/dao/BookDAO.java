package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {
    List<Book> findAll();
    Optional<Book> findById(long id);
    Book save(Book book);
    void updateAuthor(Book book);
    void updateGenre(Book book);
    void deleteById(long id);
}
