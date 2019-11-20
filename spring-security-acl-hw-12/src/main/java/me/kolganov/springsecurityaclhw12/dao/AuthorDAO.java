package me.kolganov.springsecurityaclhw12.dao;

import me.kolganov.springsecurityaclhw12.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Long> {
}
