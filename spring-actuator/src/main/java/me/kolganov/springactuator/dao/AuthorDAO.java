package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
