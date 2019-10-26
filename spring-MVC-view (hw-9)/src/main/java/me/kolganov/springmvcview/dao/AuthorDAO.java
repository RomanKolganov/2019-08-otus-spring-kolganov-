package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorDAO extends JpaRepository<Author, Long> {
    Optional<Author> findById(long id);
}
