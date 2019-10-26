package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.dao.GenreDAO;
import me.kolganov.springmvcview.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDAO dao;

    public GenreServiceImpl(GenreDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Genre> getAll() {
        return dao.findAll();
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
