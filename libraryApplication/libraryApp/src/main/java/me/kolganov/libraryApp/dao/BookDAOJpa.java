package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.domain.Book;
import me.kolganov.libraryApp.domain.Genre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class BookDAOJpa implements BookDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    @Transactional
    public void save(Book book) {
        if (book.getId() <= 0) {
            em.persist(book);
        } else {
            Book bookToSave = em.find(Book.class, book.getId());
            bookToSave.setName(book.getName());
            em.merge(bookToSave);
        }
    }

    @Override
    @Transactional
    public void updateAuthor(Book book) {
        Book bookToSave = em.find(Book.class, book.getId());
        Author authorToSave = em.find(Author.class, book.getAuthor().getId());
        bookToSave.setAuthor(authorToSave);
        em.merge(bookToSave);
    }

    @Override
    @Transactional
    public void updateGenre(Book book) {
        Book bookToSave = em.find(Book.class, book.getId());
        Genre genreToSave = em.find(Genre.class, book.getGenre().getId());
        bookToSave.setGenre(genreToSave);
        em.merge(bookToSave);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
    }
}
