package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorDAO extends MongoRepository<Author, String> {
}
