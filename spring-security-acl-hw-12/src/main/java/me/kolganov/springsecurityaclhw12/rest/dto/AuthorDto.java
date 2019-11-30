package me.kolganov.springsecurityaclhw12.rest.dto;

import me.kolganov.springsecurityaclhw12.domain.Author;

public class AuthorDto {
    private long id;
    private String name;

    public AuthorDto() {
    }

    public AuthorDto(long id, String name) {
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

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    public static Author toEntity(AuthorDto authorDto) {
        return new Author(authorDto.getId(), authorDto.getName());
    }
}
