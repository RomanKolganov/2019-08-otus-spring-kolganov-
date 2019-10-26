package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookDAO extends JpaRepository<Book, Long> {
    Optional<Book> findById(long id);
}
