package me.kolganov.springboothistryx.rest.dto;

import lombok.Builder;
import lombok.Data;
import me.kolganov.springboothistryx.domain.Comment;

@Data
@Builder
public class CommentDto {
    private long id;
    private String text;
    private BookDto bookDto;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getText(),
                BookDto.builder()
                        .id(comment.getBook().getId())
                        .name(comment.getBook().getName())
                        .build());
    }
}
