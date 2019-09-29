package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO dao;

    public BookServiceImpl(BookDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        return dao.findAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void create(Book book) {
        dao.create(book);
    }

    @Override
    public void updateName(Book book) {
        dao.updateName(book);
    }

    @Override
    public void updateAuthor(Book book) {
        dao.updateAuthor(book);
    }

    @Override
    public void updateGenre(Book book) {
        dao.updateGenre(book);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
