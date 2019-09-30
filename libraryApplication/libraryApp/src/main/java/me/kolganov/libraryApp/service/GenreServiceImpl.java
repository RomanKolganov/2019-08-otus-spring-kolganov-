package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.GenreDAO;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDAO dao;

    public GenreServiceImpl(GenreDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        return dao.findAll().stream().map(Genre::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void save(Genre genre) {
        dao.save(genre);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
