package me.kolganov.libraryApp.events;

import me.kolganov.libraryApp.dao.CommentDAO;
import me.kolganov.libraryApp.domain.Book;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.stereotype.Component;

@Component
public class CommentsCascadeDeleteEventListener extends AbstractMongoEventListener<Book> {
    private final CommentDAO commentDAO;

    public CommentsCascadeDeleteEventListener(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Book> event) {
        super.onAfterDelete(event);
        Document source = event.getSource();
        String id = source.get("_id").toString();
        commentDAO.deleteByBookId(id);
    }
}
