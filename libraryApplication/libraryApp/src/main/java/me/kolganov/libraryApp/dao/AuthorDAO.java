package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorDAO extends JpaRepository<Author, Long> {
    Optional<Author> findById(long id);
}
