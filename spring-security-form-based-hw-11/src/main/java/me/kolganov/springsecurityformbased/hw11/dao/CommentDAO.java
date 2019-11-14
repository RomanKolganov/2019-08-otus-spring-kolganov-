package me.kolganov.springsecurityformbased.hw11.dao;

import me.kolganov.springsecurityformbased.hw11.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBookId(long bookId);
}
