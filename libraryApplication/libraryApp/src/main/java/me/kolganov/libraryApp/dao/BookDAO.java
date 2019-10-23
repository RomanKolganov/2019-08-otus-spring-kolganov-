package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookDAO extends MongoRepository<Book, String> {
    void deleteAllByAuthorId(String authorId);
    void deleteAllByGenreId(String genreId);
    List<Book> findAllByAuthorId(String authorId);
    List<Book> findAllByGenreId(String genreId);
}
