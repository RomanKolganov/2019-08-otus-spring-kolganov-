package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {
}
