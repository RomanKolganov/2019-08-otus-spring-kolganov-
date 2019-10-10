package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.AuthorDAO;
import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public String getByName(String name) {
        return dao.findByName(name).toString();
    }

    @Override
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    public void update(String oldName, String newName) {
        Optional<Author> optionalAuthor = dao.findByName(oldName);

        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            author.setName(newName);
            dao.save(author);
        }
    }

    @Override
    public void delete(String name) {
        dao.deleteByName(name);
    }
}
