package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreDAO extends JpaRepository<Genre, Long> {
    Optional<Genre> findById(long id);
}
