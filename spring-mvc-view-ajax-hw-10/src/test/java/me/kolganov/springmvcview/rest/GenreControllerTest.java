package me.kolganov.springmvcview.rest;

import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.GenreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
