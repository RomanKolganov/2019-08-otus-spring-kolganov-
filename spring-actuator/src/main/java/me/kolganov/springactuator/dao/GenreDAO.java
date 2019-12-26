package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository<Genre, Long> {
}
