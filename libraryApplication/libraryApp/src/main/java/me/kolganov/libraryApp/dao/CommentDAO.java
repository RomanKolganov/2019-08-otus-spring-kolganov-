package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentDAO {
    List<Comment> findAll();
    Optional<Comment> findById(long id);
    void save(Comment comment);
    void deleteById(long id);
}
