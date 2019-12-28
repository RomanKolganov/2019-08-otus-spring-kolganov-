package me.kolganov.springactuator.rest.dto;

import me.kolganov.springactuator.domain.Book;

public class BookDto {
    private long id;
    private String name;
    private AuthorDto authorDto;
    private GenreDto genreDto;

    public BookDto() {
    }

    public BookDto(long id, String name, AuthorDto authorDto, GenreDto genreDto) {
        this.id = id;
        this.name = name;
        this.authorDto = authorDto;
        this.genreDto = genreDto;
    }

    public BookDto(long id, String name) {
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

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public GenreDto getGenreDto() {
        return genreDto;
    }

    public void setGenreDto(GenreDto genreDto) {
        this.genreDto = genreDto;
    }

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(),
                new AuthorDto(book.getAuthor().getId(), book.getAuthor().getName()),
                new GenreDto(book.getGenre().getId(), book.getGenre().getName()));
    }
}
