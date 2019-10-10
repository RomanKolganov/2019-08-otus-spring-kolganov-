package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommentDAO extends MongoRepository<Comment, String> {
}
