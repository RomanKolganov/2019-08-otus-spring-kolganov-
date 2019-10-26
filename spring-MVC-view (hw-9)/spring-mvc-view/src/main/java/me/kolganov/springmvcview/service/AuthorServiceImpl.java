package me.kolganov.springmvcview.service;

import me.kolganov.springmvcview.dao.AuthorDAO;
import me.kolganov.springmvcview.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDAO dao;

    public AuthorServiceImpl(AuthorDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Author> getAll() {
        return dao.findAll();
    }

    @Override
    public String getById(long id) {
        return dao.findById(id).toString();
    }

    @Override
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
