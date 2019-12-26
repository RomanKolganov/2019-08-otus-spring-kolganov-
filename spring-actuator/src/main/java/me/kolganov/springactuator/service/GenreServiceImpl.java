package me.kolganov.springactuator.service;

import me.kolganov.springactuator.dao.GenreDAO;
import me.kolganov.springactuator.domain.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN')")
    public void save(Genre genre) {
        dao.save(genre);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void update(Genre genre) {
        Optional<Genre> oldGenre = dao.findById(genre.getId());
        oldGenre.ifPresent(g -> {
            g.setName(genre.getName());
            dao.save(g);
        });
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(long id) {
        dao.deleteById(id);
    }
}
