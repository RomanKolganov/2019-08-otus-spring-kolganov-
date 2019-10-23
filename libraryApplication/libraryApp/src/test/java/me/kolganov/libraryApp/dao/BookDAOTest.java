//package me.kolganov.libraryApp.dao;
//
//import me.kolganov.libraryApp.domain.Author;
//import me.kolganov.libraryApp.domain.Book;
//import me.kolganov.libraryApp.domain.Genre;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DisplayName("Репозиторий на основе JPA для работы с книгами ")
//@DataJpaTest
//@RunWith(SpringRunner.class)
//class BookDAOTest {
//    @Autowired private TestEntityManager em;
//    @Autowired private BookDAO bookDAO;
//    @Autowired private AuthorDAO authorDAO;
//    @Autowired private GenreDAO genreDAO;
//
//    @DisplayName("должен сохранять и получать сущность из БД")
//    @Test
//    void saveAdnFindTest() {
//        Optional<Author> author = authorDAO.findById(2L);
//        Optional<Genre> genre = genreDAO.findById(3L);
//        Book book = new Book("Knizhra dlya chteniya");
//
//        author.ifPresent(book::setAuthor);
//        genre.ifPresent(book::setGenre);
//
//        bookDAO.save(book);
//
//        Book actualBook = em.find(Book.class, book.getId());
//
//        assertThat(actualBook).isNotNull()
//                .matches(s -> s.getName().equals(book.getName()))
//                .matches(s -> s.getAuthor().getName().equals(author.get().getName()))
//                .matches(s -> s.getGenre().getName().equals(genre.get().getName()));
//    }
//}
