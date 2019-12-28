package me.kolganov.springactuator.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Book(String name) {
        this.name = name;
    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(long id, Genre genre) {
        this.id = id;
        this.genre = genre;
    }

    public Book(long id, Author author) {
        this.id = id;
        this.author = author;
    }

    public Book() {
    }

    public long getId() {
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
