package me.kolganov.springboothistryx.dao;

import me.kolganov.springboothistryx.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
