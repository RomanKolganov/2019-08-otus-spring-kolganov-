package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе Jdbc для работы с книгами ")
@JdbcTest
@Import(BookDAOJdbc.class)
class BookDAOJdbcTest {
    private static final int EXPECTED_NUMBER_OF_AUTHORS = 7;

    @Autowired
    private BookDAOJdbc daoJdbc;

    @DisplayName("должен возвращать список всех книг")
    @Test
    void findAllTest() {
        List<Book> books = daoJdbc.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_AUTHORS)
                .allMatch(s -> !s.getName().equals(""));
    }
}
