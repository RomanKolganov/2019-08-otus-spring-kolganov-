package me.kolganov.springboothistryx.rest.dto;

import lombok.Builder;
import lombok.Data;
import me.kolganov.springboothistryx.domain.Author;

@Data
@Builder
public class AuthorDto {
    private long id;
    private String name;

    public static AuthorDto toDto(Author author) {
        return new AuthorDto(author.getId(), author.getName());
    }

    public static Author toEntity(AuthorDto authorDto) {
        return Author.builder()
                .id(authorDto.getId())
                .name(authorDto.getName())
                .build();
    }
}
