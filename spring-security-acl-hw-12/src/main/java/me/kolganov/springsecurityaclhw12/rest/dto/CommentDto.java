package me.kolganov.springsecurityaclhw12.rest.dto;

import me.kolganov.springsecurityaclhw12.domain.Comment;

public class CommentDto {
    private long id;
    private String text;
    private BookDto bookDto;

    public CommentDto() {
    }

    public CommentDto(long id, String text, BookDto bookDto) {
        this.id = id;
        this.text = text;
        this.bookDto = bookDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getText(),
                new BookDto(comment.getBook().getId(), comment.getBook().getName()));
    }
}
