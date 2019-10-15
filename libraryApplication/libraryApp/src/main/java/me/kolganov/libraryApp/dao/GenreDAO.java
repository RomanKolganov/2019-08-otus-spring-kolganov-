package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreDAO extends MongoRepository<Genre, String> {
}
