package me.kolganov.springbatch.domain.mongo;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "books")
public class BookMongo {
    @Id
    private String id;
    @Field("name")
    private String name;

    @DBRef
    @Field("authors")
    private AuthorMongo authorMongo;

    @DBRef
    @Field("genres")
    private GenreMongo genreMongo;

    public BookMongo(String name) {
        this.name = name;
    }

    public BookMongo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookMongo(String id, GenreMongo genreMongo) {
        this.id = id;
        this.genreMongo = genreMongo;
    }

    public BookMongo(String id, AuthorMongo authorMongo) {
        this.id = id;
        this.authorMongo = authorMongo;
    }

    public BookMongo(String name, AuthorMongo authorMongo, GenreMongo genreMongo) {
        this.name = name;
        this.authorMongo = authorMongo;
        this.genreMongo = genreMongo;
    }

    public BookMongo() {
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

    public void setAuthorMongo(AuthorMongo authorMongo) {
        this.authorMongo = authorMongo;
    }

    public AuthorMongo getAuthorMongo() {
        return authorMongo;
    }

    public void setGenreMongo(GenreMongo genreMongo) {
        this.genreMongo = genreMongo;
    }

    public GenreMongo getGenreMongo() {
        return genreMongo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + authorMongo.toString() +
                ", genre=" + genreMongo.toString() +
                '}';
    }
}
