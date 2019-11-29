package me.kolganov.springsecurityaclhw12.rest;

import me.kolganov.springsecurityaclhw12.config.security.CustomUserDetailsService;
import me.kolganov.springsecurityaclhw12.dao.UserRepository;
import me.kolganov.springsecurityaclhw12.domain.Author;
import me.kolganov.springsecurityaclhw12.service.AuthorService;
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

@DisplayName("Rest контроллер для работы с авторами ")
@WebMvcTest(AuthorController.class)
class AuthorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthorService authorService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )

    @Test
    @DisplayName("должен возвращать список авторов")
    void getAuthorsListTest() throws Exception {
        Author author = new Author(1, "testAuthor");
        List<Author> authors = Collections.singletonList(author);
        given(authorService.getAll()).willReturn(authors);

        this.mockMvc.perform(get("/author/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'testAuthor'}]"));
    }
}
