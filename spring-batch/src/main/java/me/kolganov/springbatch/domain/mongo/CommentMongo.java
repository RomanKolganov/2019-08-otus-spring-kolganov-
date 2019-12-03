package me.kolganov.springbatch.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "comments")
public class CommentMongo {
    @Id
    private String id;
    @Field("text")
    private String text;

    @DBRef
    @Field("books")
    private BookMongo bookMongo;

    public CommentMongo(String text) {
        this.text = text;
    }

    public CommentMongo(String text, BookMongo bookMongo) {
        this.text = text;
        this.bookMongo = bookMongo;
    }

    public CommentMongo() {
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

    public BookMongo getBookMongo() {
        return bookMongo;
    }

    public void setBookMongo(BookMongo bookMongo) {
        this.bookMongo = bookMongo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", book=" + bookMongo.toString() +
                '}';
    }
}
