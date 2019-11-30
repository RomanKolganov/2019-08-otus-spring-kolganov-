package me.kolganov.springsecurityaclhw12.page;

import me.kolganov.springsecurityaclhw12.config.security.CustomUserDetailsService;
import me.kolganov.springsecurityaclhw12.dao.UserRepository;
import me.kolganov.springsecurityaclhw12.service.GenreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Контроллер для работы с жанрами ")
@WebMvcTest(GenrePageController.class)
class GenrePageControllerTest {
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
    @DisplayName("должен возвращать шаблон genre.html при обращении")
    void shouldReturnGenreWhenAccessing() throws Exception {
        mockMvc.perform(get("/genres"))
                .andExpect(status().isOk())
                .andExpect(view().name("genre"))
                .andExpect(content().string(containsString("Жанры")));
    }
}
