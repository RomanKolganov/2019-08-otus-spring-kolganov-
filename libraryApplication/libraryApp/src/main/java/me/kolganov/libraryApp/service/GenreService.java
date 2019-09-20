package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Genre;

public interface GenreService {
    String getAll();
    String getById(long id);
    void create(Genre genre);
    void update(Genre genre);
    void delete(Genre genre);
}
