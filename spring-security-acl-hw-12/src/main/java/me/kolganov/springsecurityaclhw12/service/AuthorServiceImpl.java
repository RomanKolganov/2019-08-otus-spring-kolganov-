package me.kolganov.springsecurityaclhw12.service;

import me.kolganov.springsecurityaclhw12.dao.AuthorDAO;
import me.kolganov.springsecurityaclhw12.domain.Author;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Author getById(long id) {
        return dao.findById(id).orElseGet(Author::new);
    }

    @Override
    public void save(Author author) {
        dao.save(author);
    }

    @Override
    @PreAuthorize("hasPermission(#author, 'write') or " +
            "hasRole('ADMIN')")
    public void update(@Param("author") Author author) {
        Optional<Author> oldAuthor = dao.findById(author.getId());
        oldAuthor.ifPresent(a -> {
            a.setName(author.getName());
            dao.save(a);
        });
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}
