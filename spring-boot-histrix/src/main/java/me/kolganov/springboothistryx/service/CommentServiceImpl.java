package me.kolganov.springboothistryx.service;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.dao.BookDAO;
import me.kolganov.springboothistryx.dao.CommentDAO;
import me.kolganov.springboothistryx.domain.Book;
import me.kolganov.springboothistryx.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDAO commentDAO;
    private final BookDAO bookDAO;

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
