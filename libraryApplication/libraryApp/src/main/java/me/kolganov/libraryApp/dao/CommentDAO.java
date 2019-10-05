package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(long id);
}
