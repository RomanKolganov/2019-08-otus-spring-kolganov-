package me.kolganov.springsecurityaclhw12.service;

import me.kolganov.springsecurityaclhw12.dao.GenreDAO;
import me.kolganov.springsecurityaclhw12.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Genre getById(long id) {
        return dao.findById(id).orElseGet(Genre::new);
    }

    @Override
    public void save(Genre genre) {
        dao.save(genre);
    }

    @Override
    public void update(Genre genre) {
        Optional<Genre> oldGenre = dao.findById(genre.getId());
        oldGenre.ifPresent(g -> {
            g.setName(genre.getName());
            dao.save(g);
        });
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
