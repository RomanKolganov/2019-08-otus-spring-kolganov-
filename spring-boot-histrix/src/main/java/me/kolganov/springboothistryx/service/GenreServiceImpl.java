package me.kolganov.springboothistryx.service;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.dao.GenreDAO;
import me.kolganov.springboothistryx.domain.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreDAO dao;

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
