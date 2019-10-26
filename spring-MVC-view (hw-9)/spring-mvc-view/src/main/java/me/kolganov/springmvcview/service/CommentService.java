package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.domain.Comment;

public interface CommentService {
    String getAll();
    String getById(long id);
    void save(Comment comment, long bookId);
    void delete(long id);
}
