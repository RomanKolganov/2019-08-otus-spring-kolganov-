package me.kolganov.libraryApp.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    @Field("text")
    private String text;

    @DBRef
    @Field("books")
    private Book book;

    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, Book book) {
        this.text = text;
        this.book = book;
    }

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", book=" + book.toString() +
                '}';
    }
}
