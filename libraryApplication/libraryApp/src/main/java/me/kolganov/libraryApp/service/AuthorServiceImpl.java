package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.AuthorDAO;
import me.kolganov.libraryApp.dao.BookDAO;
import me.kolganov.libraryApp.domain.Author;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO dao;
    private final BookDAO bookDAO;

    public AuthorServiceImpl(AuthorDAO dao, BookDAO bookDAO) {
        this.dao = dao;
        this.bookDAO = bookDAO;
    }

    @Override
    public String getAll() {
        return dao.findAll().stream().map(Author::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(String id) {
        return dao.findById(id).toString();
    }

    @Override
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    public void update(String id, String newName) {
        Optional<Author> optionalAuthor = dao.findById(id);
        optionalAuthor.ifPresent(a -> {
            a.setName(newName);
            dao.save(a);
        });
    }

    @Override
    public void delete(String id) {
        Optional<Author> optionalAuthor = dao.findById(id);
        if (optionalAuthor.isPresent()) {
            bookDAO.deleteAllByAuthorId(id);
        }
        dao.deleteById(id);
    }
}
