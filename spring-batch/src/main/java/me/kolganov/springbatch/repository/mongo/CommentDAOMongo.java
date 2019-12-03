package me.kolganov.springbatch.repository.mongo;

import me.kolganov.springbatch.domain.mongo.CommentMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentDAOMongo extends MongoRepository<CommentMongo, String> {
}
