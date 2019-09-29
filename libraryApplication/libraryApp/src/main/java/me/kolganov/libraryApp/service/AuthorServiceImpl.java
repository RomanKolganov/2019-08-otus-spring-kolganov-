package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.AuthorDAO;
import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO dao;

    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        return dao.findAll().stream().map(Author::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void create(String name) {
        dao.create(new Author(name));
    }

    @Override
    public void update(Author author) {
        dao.update(author);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
