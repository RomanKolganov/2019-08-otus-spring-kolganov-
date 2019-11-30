package me.kolganov.springsecurityaclhw12.dao;

import me.kolganov.springsecurityaclhw12.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAO extends JpaRepository<Genre, Long> {
}
