package me.kolganov.libraryApp.domain;

public class Book {
    private long id;
    private String name;
    private Author author;
    private Genre genre;

    public Book(long id, String name, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
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

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
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
