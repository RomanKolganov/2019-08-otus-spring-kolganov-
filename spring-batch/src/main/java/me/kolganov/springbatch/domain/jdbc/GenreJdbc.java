package me.kolganov.springbatch.domain.jdbc;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
public class GenreJdbc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genreJdbc", cascade = CascadeType.ALL)
    private List<BookJdbc> bookJdbcs;

    public GenreJdbc(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreJdbc(long id) {
        this.id = id;
    }

    public GenreJdbc(String name) {
        this.name = name;
    }

    public GenreJdbc(){
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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
