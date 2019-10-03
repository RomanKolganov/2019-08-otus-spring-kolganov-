package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.AuthorDAO;
import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.dao.GenreDAO;
import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

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
    public String getAll() {
        return bookDAO.findAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(long id) {
        return bookDAO.findById(id).toString();
    }

    @Override
    public void save(Book book, long authorId, long genreId) {
        Optional<Author> author = authorDAO.findById(authorId);
        Optional<Genre> genre = genreDAO.findById(genreId);

        author.ifPresent(book::setAuthor);
        genre.ifPresent(book::setGenre);

        bookDAO.save(book);
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void updateAuthor(Book book) {
        bookDAO.updateAuthor(book);
    }

    @Override
    public void updateGenre(Book book) {
        bookDAO.updateGenre(book);
    }

    @Override
    public void delete(long id) {
        bookDAO.deleteById(id);
    }
}
