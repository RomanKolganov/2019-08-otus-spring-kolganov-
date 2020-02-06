package me.kolganov.springboothistryx.dao;

import me.kolganov.springboothistryx.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {
}
