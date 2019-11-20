package me.kolganov.springsecurityaclhw12.dao;

import me.kolganov.springsecurityaclhw12.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    List<Comment> findAllByBookId(long bookId);
}
