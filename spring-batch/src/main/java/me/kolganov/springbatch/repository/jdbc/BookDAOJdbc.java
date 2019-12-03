package me.kolganov.springbatch.repository.jdbc;

import me.kolganov.springbatch.domain.jdbc.BookJdbc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAOJdbc extends JpaRepository<BookJdbc, Long> {
}
