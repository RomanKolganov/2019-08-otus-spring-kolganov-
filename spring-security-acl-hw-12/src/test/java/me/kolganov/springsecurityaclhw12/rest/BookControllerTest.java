package me.kolganov.springsecurityaclhw12.rest;

import me.kolganov.springsecurityaclhw12.config.security.CustomUserDetailsService;
import me.kolganov.springsecurityaclhw12.dao.UserRepository;
import me.kolganov.springsecurityaclhw12.domain.Author;
import me.kolganov.springsecurityaclhw12.domain.Book;
import me.kolganov.springsecurityaclhw12.domain.Genre;
import me.kolganov.springsecurityaclhw12.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Rest контроллер для работы с книгами ")
@WebMvcTest(BookController.class)
class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )

    @Test
    @DisplayName("должен возвращать список книг")
    void getBooksListTest() throws Exception {
        Book book = new Book(1, "testBook");
        book.setAuthor(new Author(1, "testAuthor"));
        book.setGenre(new Genre(1, "testGenre"));

        List<Book> books = Collections.singletonList(book);
        given(bookService.getAll()).willReturn(books);

        this.mockMvc.perform(get("/book/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'name':'testBook', 'authorDto':{'id':1, 'name':'testAuthor'}, 'genreDto':{'id':1, 'name':'testGenre'}}]"));
    }
}
