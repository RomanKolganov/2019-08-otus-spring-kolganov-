package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDAO {
    List<Genre> findAll();
    Optional<Genre> findById(long id);
    Genre save(Genre genre);
    void deleteById(long id);
}
