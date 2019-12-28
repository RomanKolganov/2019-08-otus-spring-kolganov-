package me.kolganov.springactuator.service;

import me.kolganov.springactuator.dao.AuthorDAO;
import me.kolganov.springactuator.dao.BookDAO;
import me.kolganov.springactuator.dao.GenreDAO;
import me.kolganov.springactuator.domain.Author;
import me.kolganov.springactuator.domain.Book;
import me.kolganov.springactuator.domain.Genre;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;
    private final GenreDAO genreDAO;

    public BookServiceImpl(BookDAO bookDAO, AuthorDAO authorDAO, GenreDAO genreDAO) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
        this.genreDAO = genreDAO;
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book getById(long id) {
        return bookDAO.findById(id).orElseGet(Book::new);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void save(Book book, long authorId, long genreId) {
        Optional<Author> author = authorDAO.findById(authorId);
        Optional<Genre> genre = genreDAO.findById(genreId);

        author.ifPresent(book::setAuthor);
        genre.ifPresent(book::setGenre);

        bookDAO.save(book);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void update(Book book, long authorId, long genreId) {
        Optional<Book> bookFromDb = bookDAO.findById(book.getId());
        Optional<Author> author = authorDAO.findById(authorId);
        Optional<Genre> genre = genreDAO.findById(genreId);

        bookFromDb.ifPresent(s -> {
            s.setName(book.getName());
            s.setAuthor(author.orElseGet(Author::new));
            s.setGenre(genre.orElseGet(Genre::new));
            bookDAO.save(s);
        });
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(long id) {
        bookDAO.deleteById(id);
    }
}
