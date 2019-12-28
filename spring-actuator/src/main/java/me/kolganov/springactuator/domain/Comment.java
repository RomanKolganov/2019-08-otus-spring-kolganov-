package me.kolganov.springactuator.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text")
    private String text;

    @ManyToOne (targetEntity = Book.class)
    @JoinColumn(name = "book_id")
    private Book book;

    public Comment(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Comment(String text) {
        this.text = text;
    }

    public Comment() {
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
