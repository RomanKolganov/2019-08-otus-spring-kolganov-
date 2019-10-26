package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.domain.Comment;
import me.kolganov.springmvcview.dao.BookDAO;
import me.kolganov.springmvcview.dao.CommentDAO;
import me.kolganov.springmvcview.domain.Book;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final BookDAO bookDAO;

    public CommentServiceImpl(CommentDAO commentDAO, BookDAO bookDAO) {
        this.commentDAO = commentDAO;
        this.bookDAO = bookDAO;
    }

    @Override
    public String getAll() {
        return commentDAO.findAll().stream().map(Comment::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(long id) {
        Optional<Comment> comment = commentDAO.findById(id);

        if (comment.isPresent()) {
            return comment.get().toString();
        }
        return "Comment id=" + id + " is empty";
    }

    @Override
    public void save(Comment comment, long bookId) {
        Optional<Book> book = bookDAO.findById(bookId);
        book.ifPresent(comment::setBook);

        commentDAO.save(comment);
    }

    @Override
    public void delete(long id) {
        commentDAO.deleteById(id);
    }
}
