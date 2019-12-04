package me.kolganov.springbatch.domain.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "authors")
public class AuthorMongo {
    @Id
    private String id;
    @Field("name")
    private String name;

    public AuthorMongo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorMongo(String id) {
        this.id = id;
    }

    public AuthorMongo() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
