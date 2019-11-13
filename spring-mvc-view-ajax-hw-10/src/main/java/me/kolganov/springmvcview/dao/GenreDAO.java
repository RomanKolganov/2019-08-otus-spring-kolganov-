package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository<Genre, Long> {
}
