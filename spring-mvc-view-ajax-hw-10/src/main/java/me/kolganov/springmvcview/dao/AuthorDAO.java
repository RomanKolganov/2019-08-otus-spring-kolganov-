package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
