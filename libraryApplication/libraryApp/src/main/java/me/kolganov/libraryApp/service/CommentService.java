package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Comment;

public interface CommentService {
    String getAll();
    String getById(long id);
    void save(Comment comment, long bookId);
    void delete(long id);
}
