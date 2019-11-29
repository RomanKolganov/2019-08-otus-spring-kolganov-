package me.kolganov.springsecurityaclhw12.rest;

import me.kolganov.springsecurityaclhw12.config.security.CustomUserDetailsService;
import me.kolganov.springsecurityaclhw12.dao.UserRepository;
import me.kolganov.springsecurityaclhw12.domain.Genre;
import me.kolganov.springsecurityaclhw12.service.GenreService;
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

@DisplayName("Rest контроллер для работы с жанрами ")
@WebMvcTest(GenreController.class)
class GenreControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreService genreService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )

    @Test
    @DisplayName("должен возвращать список жанров")
    void getGenresListTest() throws Exception {
        Genre genre = new Genre(1, "testGenre");
        List<Genre> genres = Collections.singletonList(genre);
        given(genreService.getAll()).willReturn(genres);

        this.mockMvc.perform(get("/genre/"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'testGenre'}]"));
    }
}
