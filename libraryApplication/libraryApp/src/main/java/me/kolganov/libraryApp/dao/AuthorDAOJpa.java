package me.kolganov.libraryApp.dao;

import me.kolganov.libraryApp.domain.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorDAOJpa implements AuthorDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Author> findAll() {
        return em.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }

    @Override
    @Transactional
    public void save(Author author) {
        if (author.getId() <= 0) {
            em.persist(author);
        } else {
            em.merge(author);
        }
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Author author = em.find(Author.class, id);
        em.remove(author);
    }
}
