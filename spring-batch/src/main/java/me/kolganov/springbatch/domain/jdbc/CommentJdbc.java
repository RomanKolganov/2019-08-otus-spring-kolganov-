package me.kolganov.springbatch.domain.jdbc;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentJdbc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "text")
    private String text;

    @ManyToOne (targetEntity = BookJdbc.class)
    @JoinColumn(name = "book_id")
    private BookJdbc bookJdbc;

    public CommentJdbc(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public CommentJdbc(String text) {
        this.text = text;
    }

    public CommentJdbc() {
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

    public BookJdbc getBookJdbc() {
        return bookJdbc;
    }

    public void setBookJdbc(BookJdbc bookJdbc) {
        this.bookJdbc = bookJdbc;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", book=" + bookJdbc.toString() +
                '}';
    }
}
