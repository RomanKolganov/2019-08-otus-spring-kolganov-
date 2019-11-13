package me.kolganov.springmvcview.page;

import me.kolganov.springmvcview.service.BookService;
import me.kolganov.springmvcview.service.CommentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("Контроллер для работы с комментариями ")
@WebMvcTest(CommentPageController.class)
class CommentPageControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CommentService commentService;
    @MockBean
    private BookService bookService;

    @Test
    @DisplayName("должен возвращать шаблон comment при обращении")
    void shouldReturnCommentWhenAccessing() throws Exception {
        mockMvc.perform(get("/comments").param("book_id", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("comment"))
                .andExpect(content().string(containsString("Комментарии")));
    }
}
