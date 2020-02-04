package me.kolganov.springboothistryx.dao;

import me.kolganov.springboothistryx.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository<Genre, Long> {
}
