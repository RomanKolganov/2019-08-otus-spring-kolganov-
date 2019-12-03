package me.kolganov.springbatch.repository.mongo;

import me.kolganov.springbatch.domain.mongo.BookMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDAOMongo extends MongoRepository<BookMongo, String> {
}
