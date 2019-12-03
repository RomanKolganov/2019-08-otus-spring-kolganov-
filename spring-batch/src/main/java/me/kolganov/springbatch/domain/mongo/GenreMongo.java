package me.kolganov.springbatch.domain.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "genres")
public class GenreMongo {
    @Id
    private String id;
    @Field("name")
    private String name;

    public GenreMongo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public GenreMongo(String name) {
        this.name = name;
    }

    public GenreMongo(){
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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
