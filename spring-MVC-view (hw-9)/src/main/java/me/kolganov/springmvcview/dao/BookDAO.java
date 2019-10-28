package me.kolganov.springmvcview.dao;

import me.kolganov.springmvcview.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {
}
