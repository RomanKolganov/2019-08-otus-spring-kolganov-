package me.kolganov.springsecurityformbased.hw11.dao;

import me.kolganov.springsecurityformbased.hw11.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
