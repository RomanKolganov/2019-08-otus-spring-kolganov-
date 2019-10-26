package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.dao.AuthorDAO;
import me.kolganov.springmvcview.dao.BookDAO;
import me.kolganov.springmvcview.dao.GenreDAO;
import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.domain.Genre;
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
        Optional<Book> bookFromDb = bookDAO.findById(book.getId());
        bookFromDb.ifPresent(s -> s.setName(book.getName()));
        bookFromDb.ifPresent(bookDAO::save);
    }

    @Override
    public void delete(long id) {
        bookDAO.deleteById(id);
    }
}
