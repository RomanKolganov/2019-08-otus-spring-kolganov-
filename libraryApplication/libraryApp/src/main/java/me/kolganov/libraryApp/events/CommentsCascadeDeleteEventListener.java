package me.kolganov.libraryApp.events;

import com.mongodb.DBRef;
import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.dao.CommentDAO;
import me.kolganov.libraryApp.domain.Book;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsCascadeDeleteEventListener extends AbstractMongoEventListener<Book> {
    private final CommentDAO commentDAO;
    private final BookDAO bookDAO;

    public CommentsCascadeDeleteEventListener(CommentDAO commentDAO, BookDAO bookDAO) {
        this.commentDAO = commentDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Book> event) {
        Document source = event.getSource();
        if (source.containsKey("_id")) {
            String id = source.get("_id").toString();
            commentDAO.deleteByBookId(id);
        } else if (source.containsKey("authors")) {
            DBRef map = (DBRef) source.get("authors");
            String authorId = map.getId().toString();
            List<Book> books = bookDAO.findAllByAuthorId(authorId);
            for (Book b : books) {
                commentDAO.deleteByBookId(b.getId());
            }
        } else if (source.containsKey("genres")) {
            DBRef map = (DBRef) source.get("genres");
            String genreId = map.getId().toString();
            List<Book> books = bookDAO.findAllByGenreId(genreId);
            for (Book b : books) {
                commentDAO.deleteByBookId(b.getId());
            }
        }
    }
}
