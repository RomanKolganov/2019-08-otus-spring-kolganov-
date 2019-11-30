package me.kolganov.springsecurityaclhw12.service;

import me.kolganov.springsecurityaclhw12.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();
    Genre getById(long id);
    void save(Genre genre);
    void update(Genre genre);
    void delete(long id);
}
