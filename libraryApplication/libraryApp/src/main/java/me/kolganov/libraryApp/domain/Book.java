package me.kolganov.libraryApp.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "books")
public class Book {
    @Id
    private String id;
    @Field("name")
    private String name;

    @DBRef
    @Field("authors")
    private Author author;

    @DBRef
    @Field("genres")
    private Genre genre;

    public Book(String name) {
        this.name = name;
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String id, Genre genre) {
        this.id = id;
        this.genre = genre;
    }

    public Book(String id, Author author) {
        this.id = id;
        this.author = author;
    }

    public Book(String name, Author author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author.toString() +
                ", genre=" + genre.toString() +
                '}';
    }
}
