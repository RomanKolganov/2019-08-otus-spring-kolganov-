package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Comment;

public interface CommentService {
    String getAll();
    String getById(String id);
    void save(Comment comment, String bookId);
    void delete(String id);
}
