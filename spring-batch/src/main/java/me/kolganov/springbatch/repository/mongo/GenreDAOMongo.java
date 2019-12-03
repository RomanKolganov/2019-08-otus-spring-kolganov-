package me.kolganov.springbatch.repository.mongo;

import me.kolganov.springbatch.domain.mongo.GenreMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreDAOMongo extends MongoRepository<GenreMongo, String> {
}
