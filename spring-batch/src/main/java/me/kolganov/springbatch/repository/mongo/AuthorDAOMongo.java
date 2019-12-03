package me.kolganov.springbatch.repository.mongo;

import me.kolganov.springbatch.domain.mongo.AuthorMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorDAOMongo extends MongoRepository<AuthorMongo, String> {
}
