package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookDAO extends MongoRepository<Book, String> {
}
