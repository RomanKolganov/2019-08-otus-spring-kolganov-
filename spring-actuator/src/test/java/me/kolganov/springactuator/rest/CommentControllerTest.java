package me.kolganov.springactuator.rest;

import me.kolganov.springactuator.dao.UserRepository;
import me.kolganov.springactuator.domain.Book;
import me.kolganov.springactuator.domain.Comment;
import me.kolganov.springactuator.security.CustomUserDetailsService;
import me.kolganov.springactuator.service.CommentService;
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

@DisplayName("Rest контроллер для работы с комментариями ")
@WebMvcTest(CommentController.class)
class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CommentService commentService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @WithMockUser(
            username = "admin",
            authorities = {"ROLE_ADMIN"}
    )

    @Test
    @DisplayName("должен возвращать список комментариев для книги")
    void getCommentsListTest() throws Exception {
        Comment comment = new Comment(1, "testText");
        comment.setBook(new Book(1, "testBook"));

        List<Comment> comments = Collections.singletonList(comment);
        given(commentService.getAllByBookId(1)).willReturn(comments);

        this.mockMvc.perform(get("/comment/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':1,'text':'testText', 'bookDto':{'id':1, 'name':'testBook'}}]"));
    }
}
