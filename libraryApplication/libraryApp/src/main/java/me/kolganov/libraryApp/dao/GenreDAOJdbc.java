package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOJdbc implements GenreDAO {
    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Genre findById(long id) {
        return null;
    }

    @Override
    public void create(Genre genre) {

    }

    @Override
    public void update(Genre genre) {

    }

    @Override
    public void delete(Genre genre) {

    }
}
