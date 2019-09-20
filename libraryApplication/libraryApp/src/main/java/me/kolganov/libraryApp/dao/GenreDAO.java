package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> findAll();
    Genre findById(long id);
    void create(Genre genre);
    void update(Genre genre);
    void delete(Genre genre);
}
