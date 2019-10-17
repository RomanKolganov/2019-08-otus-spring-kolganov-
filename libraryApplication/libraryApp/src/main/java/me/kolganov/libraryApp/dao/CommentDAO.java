package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDAO extends MongoRepository<Comment, String> {
    void deleteByBookId(String bookId);
}
