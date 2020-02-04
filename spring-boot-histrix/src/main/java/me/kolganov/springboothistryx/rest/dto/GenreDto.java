package me.kolganov.springboothistryx.rest.dto;

import lombok.Builder;
import lombok.Data;
import me.kolganov.springboothistryx.domain.Genre;

@Data
@Builder
public class GenreDto {
    private long id;
    private String name;

    public static GenreDto toDto(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName());
    }

    public static Genre toEntity(GenreDto genreDto) {
        return Genre.builder()
                .id(genreDto.getId())
                .name(genreDto.getName())
                .build();
    }
}
