package me.kolganov.libraryApp.service;

import me.kolganov.libraryApp.dao.AuthorDAO;
import me.kolganov.libraryApp.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO dao;

    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    @Override
    public String getAll() {
        List<Author> authors = dao.findAll();

        StringBuilder stringBuilder = new StringBuilder();

        for (Author a : authors) {
            stringBuilder.append(a.toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void create(String name) {
        Author author = new Author();
        author.setName(name);

        dao.create(author);
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
