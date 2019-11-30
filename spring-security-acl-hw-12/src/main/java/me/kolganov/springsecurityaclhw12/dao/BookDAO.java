package me.kolganov.springsecurityaclhw12.dao;

import me.kolganov.springsecurityaclhw12.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Long> {
}
