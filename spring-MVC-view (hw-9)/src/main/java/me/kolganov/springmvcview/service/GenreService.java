package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    Genre getById(long id);
    void save(Genre genre);
    void update(Genre genre);
    void delete(long id);
}
