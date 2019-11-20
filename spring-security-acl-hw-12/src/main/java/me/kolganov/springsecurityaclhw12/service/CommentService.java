package me.kolganov.springsecurityaclhw12.service;

import me.kolganov.springsecurityaclhw12.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBookId(long bookId);
    Comment getById(long id);
    void save(Comment comment, long bookId);
    void update(Comment comment, long bookId);
    void delete(long id);
}
