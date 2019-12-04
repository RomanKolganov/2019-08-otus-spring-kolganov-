package me.kolganov.springbatch.config;

import me.kolganov.springbatch.domain.jdbc.AuthorJdbc;
import me.kolganov.springbatch.domain.jdbc.BookJdbc;
import me.kolganov.springbatch.domain.jdbc.CommentJdbc;
import me.kolganov.springbatch.domain.jdbc.GenreJdbc;
import me.kolganov.springbatch.domain.mongo.AuthorMongo;
import me.kolganov.springbatch.domain.mongo.BookMongo;
import me.kolganov.springbatch.domain.mongo.CommentMongo;
import me.kolganov.springbatch.domain.mongo.GenreMongo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

import javax.persistence.EntityManagerFactory;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private MongoOperations mongoOperations;

    @Bean
    public JpaPagingItemReader<AuthorJdbc> authorReader() {
        return new JpaPagingItemReaderBuilder<AuthorJdbc>()
                .name("authorReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select a from AuthorJdbc a")
                .build();
    }
    @Bean
    public JpaPagingItemReader<GenreJdbc> genreReader() {
        return new JpaPagingItemReaderBuilder<GenreJdbc>()
                .name("genreReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select g from GenreJdbc g")
                .build();
    }
    @Bean
    public JpaPagingItemReader<BookJdbc> bookReader() {
        return new JpaPagingItemReaderBuilder<BookJdbc>()
                .name("bookReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select b from BookJdbc b")
                .build();
    }
    @Bean
    public JpaPagingItemReader<CommentJdbc> commentReader() {
        return new JpaPagingItemReaderBuilder<CommentJdbc>()
                .name("commentReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select c from CommentJdbc c")
                .build();
    }

    @Bean//Оставил специально для примера и понимания, что вообще происходит
    public ItemProcessor<AuthorJdbc, AuthorMongo> authorProcessor() {
        ItemProcessor<AuthorJdbc, AuthorMongo> processor = new ItemProcessor<AuthorJdbc, AuthorMongo>() {
            @Override
            public AuthorMongo process(AuthorJdbc authorJdbc) throws Exception {
                return new AuthorMongo(String.valueOf(authorJdbc.getId()), authorJdbc.getName());
            }
        };
        return processor;
    }
    @Bean
    public ItemProcessor<GenreJdbc, GenreMongo> genreProcessor() {
        return genreJdbc -> new GenreMongo(String.valueOf(genreJdbc.getId()), genreJdbc.getName());
    }
    @Bean
    public ItemProcessor<BookJdbc, BookMongo> bookProcessor() {
        return bookJdbc -> new BookMongo(
                String.valueOf(bookJdbc.getId()),
                bookJdbc.getName(),
                new AuthorMongo(String.valueOf(bookJdbc.getAuthorJdbc().getId())),
                new GenreMongo(String.valueOf(bookJdbc.getGenreJdbc().getId())));
    }
    @Bean
    public ItemProcessor<CommentJdbc, CommentMongo> commentProcessor() {
        return commentJdbc -> new CommentMongo(
                String.valueOf(commentJdbc.getId()),
                commentJdbc.getText(),
                new BookMongo(String.valueOf(commentJdbc.getId())));
    }

    @Bean
    public MongoItemWriter<AuthorMongo> authorWriter() {
        return new MongoItemWriterBuilder<AuthorMongo>()
                .collection("authors")
                .template(mongoOperations)
                .build();
    }
    @Bean
    public MongoItemWriter<GenreMongo> genreWriter() {
        return new MongoItemWriterBuilder<GenreMongo>()
                .collection("genres")
                .template(mongoOperations)
                .build();
    }
    @Bean
    public MongoItemWriter<BookMongo> bookWriter() {
        return new MongoItemWriterBuilder<BookMongo>()
                .collection("books")
                .template(mongoOperations)
                .build();
    }
    @Bean
    public MongoItemWriter<CommentMongo> commentWriter() {
        return new MongoItemWriterBuilder<CommentMongo>()
                .collection("comments")
                .template(mongoOperations)
                .build();
    }

    @Bean
    public Step authorStep(MongoItemWriter authorWriter, JpaPagingItemReader authorReader, ItemProcessor authorProcessor) {
        return stepBuilderFactory.get("authorStep")
                .chunk(5)
                .reader(authorReader)
                .processor(authorProcessor)
                .writer(authorWriter)
                .build();
    }
    @Bean
    public Step genreStep(MongoItemWriter genreWriter, JpaPagingItemReader genreReader, ItemProcessor genreProcessor) {
        return stepBuilderFactory.get("genreStep")
                .chunk(5)
                .reader(genreReader)
                .processor(genreProcessor)
                .writer(genreWriter)
                .build();
    }
    @Bean
    public Step bookStep(MongoItemWriter bookWriter, JpaPagingItemReader bookReader, ItemProcessor bookProcessor) {
        return stepBuilderFactory.get("bookStep")
                .chunk(5)
                .reader(bookReader)
                .processor(bookProcessor)
                .writer(bookWriter)
                .build();
    }
    @Bean
    public Step commentStep(MongoItemWriter commentWriter, JpaPagingItemReader commentReader, ItemProcessor commentProcessor) {
        return stepBuilderFactory.get("commentStep")
                .chunk(5)
                .reader(commentReader)
                .processor(commentProcessor)
                .writer(commentWriter)
                .build();
    }

    @Bean
    public Job migrationJob(Step authorStep, Step genreStep, Step bookStep, Step commentStep) {
        return jobBuilderFactory.get("migrationJob5")
                .incrementer(new RunIdIncrementer())
                .start(authorStep)
                .next(genreStep)
                .next(bookStep)
                .next(commentStep)
                .build();
    }
}
