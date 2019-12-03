package me.kolganov.springbatch.domain.jdbc;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class BookJdbc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = AuthorJdbc.class)
    @JoinColumn(name = "author_id")
    private AuthorJdbc authorJdbc;
    @OneToOne(targetEntity = GenreJdbc.class)
    @JoinColumn(name = "genre_id")
    private GenreJdbc genreJdbc;

    @OneToMany(mappedBy = "bookJdbc", cascade = CascadeType.ALL)
    private List<CommentJdbc> commentJdbcs;

    public BookJdbc(String name) {
        this.name = name;
    }

    public BookJdbc(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookJdbc(long id, GenreJdbc genreJdbc) {
        this.id = id;
        this.genreJdbc = genreJdbc;
    }

    public BookJdbc(long id, AuthorJdbc authorJdbc) {
        this.id = id;
        this.authorJdbc = authorJdbc;
    }

    public BookJdbc() {
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

    public void setAuthorJdbc(AuthorJdbc authorJdbc) {
        this.authorJdbc = authorJdbc;
    }

    public AuthorJdbc getAuthorJdbc() {
        return authorJdbc;
    }

    public void setGenreJdbc(GenreJdbc genreJdbc) {
        this.genreJdbc = genreJdbc;
    }

    public GenreJdbc getGenreJdbc() {
        return genreJdbc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + authorJdbc.toString() +
                ", genre=" + genreJdbc.toString() +
                '}';
    }
}
