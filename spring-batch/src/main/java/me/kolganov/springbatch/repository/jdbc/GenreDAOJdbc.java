package me.kolganov.springbatch.repository.jdbc;

import me.kolganov.springbatch.domain.jdbc.GenreJdbc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDAOJdbc extends JpaRepository<GenreJdbc, Long> {
}
