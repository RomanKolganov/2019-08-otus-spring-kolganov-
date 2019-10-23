package me.kolganov.libraryApp.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import me.kolganov.libraryApp.domain.Comment;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {
    private Author pushkin;
    private Author lermontov;

    private Genre fairyTale;
    private Genre verse;
    private Genre novel;

    private Book borodino;

    @ChangeSet(order = "000", id = "dropDB", author = "ramoni73", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "001", id = "initAuthors", author = "ramoni73", runAlways = true)
    public void initAuthors(MongoTemplate template){
        pushkin = template.save(new Author("Пушкин А.С."));
        lermontov = template.save(new Author("Лермонтов М.Ю."));
    }

    @ChangeSet(order = "002", id = "initGenres", author = "ramoni73", runAlways = true)
    public void initGenres(MongoTemplate template){
        fairyTale = template.save(new Genre("Сказка"));
        verse = template.save(new Genre("Поэзия"));
        novel = template.save(new Genre("Роман"));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "ramoni73", runAlways = true)
    public void initBooks(MongoTemplate template){
        template.save(new Book("Сказка о попе и о работнике его Балде", pushkin, fairyTale));
        template.save(new Book("Сказка о золотом петушке", pushkin, fairyTale));
        template.save(new Book("Руслан и Людмила", pushkin, verse));
        template.save(new Book("Евгений Онегин", pushkin, novel));

        borodino = template.save(new Book("Бородино", lermontov, verse));
        template.save(new Book("Парус", lermontov, verse));
        template.save(new Book("Герой нашего времени", lermontov, novel));
    }

    @ChangeSet(order = "004", id = "initComments", author = "ramoni73", runAlways = true)
    public void initComments(MongoTemplate template){
        template.save(new Comment("Концовка норм :)", borodino));
    }
}
