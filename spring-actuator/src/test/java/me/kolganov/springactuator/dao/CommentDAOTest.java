package me.kolganov.springactuator.dao;

import me.kolganov.springactuator.domain.Book;
import me.kolganov.springactuator.domain.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Репозиторий на основе JPA для работы с комментариями ")
@DataJpaTest
class CommentDAOTest {
    @Autowired
    private TestEntityManager em;
    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private BookDAO bookDAO;

    @DisplayName("должен сохранять и получать сущность из БД")
    @Test
    void saveAndFindTest() {
        Optional<Book> book = bookDAO.findById(3L);
        Comment comment = new Comment("normul`");
        book.ifPresent(comment::setBook);

        commentDAO.save(comment);
        Comment actualComment = em.find(Comment.class, comment.getId());

        assertThat(actualComment).isNotNull().matches(s -> s.getText().equals(comment.getText()));

    }
}
