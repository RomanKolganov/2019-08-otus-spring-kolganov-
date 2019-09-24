package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.GenreDAO;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDAO dao;

    public GenreServiceImpl(GenreDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        List<Genre> genres = dao.findAll();

        StringBuilder stringBuilder = new StringBuilder();

        for (Genre g : genres) {
            stringBuilder.append(g.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void create(String name) {
        Genre genre = new Genre();
        genre.setName(name);

        dao.create(genre);
    }

    @Override
    public void update(Genre genre) {
        dao.update(genre);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
