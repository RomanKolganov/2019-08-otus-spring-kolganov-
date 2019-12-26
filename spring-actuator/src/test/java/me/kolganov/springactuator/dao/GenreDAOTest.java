package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Репозиторий на основе JPA для работы с жанрами ")
@DataJpaTest
class GenreDAOTest {
    @Autowired
    private GenreDAO genreDAOJpa;
    @Autowired
    private TestEntityManager em;

    @DisplayName("должен сохранять и получать сущность из БД")
    @Test
    void saveAndFindTest() {
        Genre genre = new Genre("newGenre");
        genreDAOJpa.save(genre);

        Genre actualGenre = em.find(Genre.class, genre.getId());

        assertThat(actualGenre).isNotNull().matches(s -> s.getName().equals(genre.getName()));
    }
}
