package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе JPA для работы с авторами ")
@DataJpaTest
class AuthorDAOTest {
    @Autowired
    private AuthorDAO daoJpa;
    @Autowired
    private TestEntityManager em;

    @DisplayName("должен сохранять и получать сущность из БД")
    @Test
    void saveAndFindTest() {
        Author author = new Author("authorName");
        daoJpa.save(author);

        Author actualAuthor = em.find(Author.class, author.getId());

        assertThat(actualAuthor).isNotNull().matches(s -> s.getName().equals(author.getName()));
    }
}

