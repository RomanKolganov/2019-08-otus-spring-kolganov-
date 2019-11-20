package me.kolganov.springsecurityaclhw12.rest.dto;

import me.kolganov.springsecurityaclhw12.domain.Genre;

public class GenreDto {
    private long id;
    private String name;

    public GenreDto() {
    }

    public GenreDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    public static Genre toEntity(GenreDto genreDto) {
        return new Genre(genreDto.getId(), genreDto.getName());
    }
}
