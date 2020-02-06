package me.kolganov.springboothistryx.rest.dto;

import lombok.Builder;
import lombok.Data;
import me.kolganov.springboothistryx.domain.Book;

@Data
@Builder
public class BookDto {
    private long id;
    private String name;
    private AuthorDto authorDto;
    private GenreDto genreDto;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(),
                new AuthorDto(book.getAuthor().getId(), book.getAuthor().getName()),
                new GenreDto(book.getGenre().getId(), book.getGenre().getName()));
    }
}
