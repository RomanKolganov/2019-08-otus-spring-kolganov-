package me.kolganov.springsecurityformbased.hw11.service;

import me.kolganov.springsecurityformbased.hw11.dao.BookDAO;
import me.kolganov.springsecurityformbased.hw11.dao.CommentDAO;
import me.kolganov.springsecurityformbased.hw11.domain.Book;
import me.kolganov.springsecurityformbased.hw11.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final BookDAO bookDAO;

    public CommentServiceImpl(CommentDAO commentDAO, BookDAO bookDAO) {
        this.commentDAO = commentDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Comment> getAllByBookId(long bookId) {
        return commentDAO.findAllByBookId(bookId);
    }

    @Override
    public Comment getById(long id) {
        return commentDAO.findById(id).orElseGet(Comment::new);
    }

    @Override
    public void save(Comment comment, long bookId) {
        Optional<Book> book = bookDAO.findById(bookId);
        book.ifPresent(comment::setBook);

        commentDAO.save(comment);
    }

    @Override
    public void update(Comment comment, long bookId) {
        Optional<Comment> oldComment = commentDAO.findById(comment.getId());
        Optional<Book> book = bookDAO.findById(bookId);

        oldComment.ifPresent(c -> {
            c.setText(comment.getText());
            c.setBook(book.orElseGet(Book::new));
            commentDAO.save(c);
        });
    }

    @Override
    public void delete(long id) {
        commentDAO.deleteById(id);
    }
}
