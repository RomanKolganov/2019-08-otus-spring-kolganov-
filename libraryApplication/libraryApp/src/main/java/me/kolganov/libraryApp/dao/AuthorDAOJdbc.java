package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOJdbc implements AuthorDAO {
    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public Author findById(long id) {
        return null;
    }

    @Override
    public void create(Author author) {

    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void deleteById(long id) {

    }
}
