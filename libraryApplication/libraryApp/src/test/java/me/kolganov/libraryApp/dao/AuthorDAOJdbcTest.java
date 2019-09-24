package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе Jdbc для работы с авторами ")
@JdbcTest
@Import(AuthorDAOJdbc.class)
class AuthorDAOJdbcTest {
    private static final int EXPECTED_NUMBER_OF_AUTHORS = 2;

    @Autowired
    private AuthorDAOJdbc daoJdbc;

    @DisplayName("должен загружать список всех авторов")
    @Test
    void findAllTest() {
        List<Author> authors = daoJdbc.findAll();
        assertThat(authors).isNotNull().hasSize(EXPECTED_NUMBER_OF_AUTHORS)
                .allMatch(s -> !s.getName().equals(""));
    }

    @DisplayName("должен возвращаять Пушкина А.С.")
    @Test
    void findByIdTest() {
        Author author = daoJdbc.findById(1);
        assertThat(author).isNotNull().matches(s -> s.getName().equals("Пушкин А.С."));
    }
}
