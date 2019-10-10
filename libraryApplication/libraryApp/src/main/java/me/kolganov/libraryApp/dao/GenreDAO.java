package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GenreDAO extends MongoRepository<Genre, String> {
    Optional<Genre> findByName(String name);
    void deleteByName(String name);
}
