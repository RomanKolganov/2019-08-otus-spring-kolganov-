package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOJdbc implements BookDAO {
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public void create(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }
}
