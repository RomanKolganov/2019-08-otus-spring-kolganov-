package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreDAO extends JpaRepository<Genre, Long> {
    Optional<Genre> findById(long id);
}
