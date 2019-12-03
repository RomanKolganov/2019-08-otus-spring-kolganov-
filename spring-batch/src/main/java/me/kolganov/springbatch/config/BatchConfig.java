package me.kolganov.springbatch.config;

import me.kolganov.springbatch.domain.jdbc.AuthorJdbc;
import me.kolganov.springbatch.domain.mongo.AuthorMongo;
import me.kolganov.springbatch.repository.mongo.AuthorDAOMongo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
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
    public MongoItemWriter<AuthorMongo> authorWriter() {
        return new MongoItemWriterBuilder<AuthorMongo>()
                .collection("authors")
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
    public Job migrationJob(Step authorStep) {
        return jobBuilderFactory.get("migrationJob")
                .start(authorStep)
                .build();
    }
}
