package me.kolganov.springbatch.domain.jdbc;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorJdbc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "authorJdbc", cascade = CascadeType.ALL)
    private List<BookJdbc> bookJdbcs;

    public AuthorJdbc(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorJdbc(long id) {
        this.id = id;
    }

    public AuthorJdbc(String name) {
        this.name = name;
    }

    public AuthorJdbc() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookJdbc> getBookJdbcs() {
        return bookJdbcs;
    }

    public void setBookJdbcs(List<BookJdbc> bookJdbcs) {
        this.bookJdbcs = bookJdbcs;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
