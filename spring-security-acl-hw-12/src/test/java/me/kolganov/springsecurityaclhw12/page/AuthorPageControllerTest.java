package me.kolganov.springsecurityaclhw12.page;

import me.kolganov.springsecurityaclhw12.config.security.CustomUserDetailsService;
import me.kolganov.springsecurityaclhw12.dao.UserRepository;
import me.kolganov.springsecurityaclhw12.service.AuthorService;
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

@DisplayName("Контроллер для работы с авторами ")
@WebMvcTest(AuthorPageController.class)
class AuthorPageControllerTest {
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
    @DisplayName("должен возвращать шаблон author.html при обращении")
    void shouldReturnAuthorWhenAccessing() throws Exception {
        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(view().name("author"))
                .andExpect(content().string(containsString("Авторы")));
    }
}
