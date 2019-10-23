package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Genre;

public interface GenreService {
    String getAll();
    String getById(String id);
    void save(Genre genre);
    void delete(String id);
}
