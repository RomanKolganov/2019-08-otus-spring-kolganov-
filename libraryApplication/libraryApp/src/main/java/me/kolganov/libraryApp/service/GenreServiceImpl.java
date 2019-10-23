package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.dao.GenreDAO;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDAO dao;
    private final BookDAO bookDAO;

    public GenreServiceImpl(GenreDAO dao, BookDAO bookDAO) {
        this.dao = dao;
        this.bookDAO = bookDAO;
    }

    @Override
    public String getAll() {
        return dao.findAll().stream().map(Genre::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(String id) {
        return dao.findById(id).toString();
    }

    @Override
    public void save(Genre genre) {
        dao.save(genre);
    }

    @Override
    public void delete(String id) {
        Optional<Genre> optionalGenre = dao.findById(id);
        if (optionalGenre.isPresent()) {
            bookDAO.deleteAllByGenreId(id);
        }
        dao.deleteById(id);
    }
}
