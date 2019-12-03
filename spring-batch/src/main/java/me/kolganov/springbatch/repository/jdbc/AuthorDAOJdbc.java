package me.kolganov.springbatch.repository.jdbc;

import me.kolganov.springbatch.domain.jdbc.AuthorJdbc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAOJdbc extends JpaRepository<AuthorJdbc, Long> {
}
