package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookDAO extends MongoRepository<Book, String> {
    Optional<Book> findByName(String name);
    void deleteByName(String name);
}
