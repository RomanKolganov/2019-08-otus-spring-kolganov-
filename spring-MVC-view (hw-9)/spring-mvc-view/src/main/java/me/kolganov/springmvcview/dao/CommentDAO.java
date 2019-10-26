package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentDAO extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(long id);
}
