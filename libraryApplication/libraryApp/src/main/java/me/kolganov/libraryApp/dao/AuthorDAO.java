package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorDAO extends MongoRepository<Author, String> {
    Optional<Author> findByName(String name);
    void deleteByName(String name);
}
