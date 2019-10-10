package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.domain.Genre;

public interface GenreService {
    String getAll();
    String getByName(String name);
    void save(Genre genre);
    void delete(String name);
}
