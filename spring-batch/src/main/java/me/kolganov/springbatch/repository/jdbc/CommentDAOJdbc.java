package me.kolganov.springbatch.repository.jdbc;

import me.kolganov.springbatch.domain.jdbc.CommentJdbc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDAOJdbc extends JpaRepository<CommentJdbc, Long> {
}
