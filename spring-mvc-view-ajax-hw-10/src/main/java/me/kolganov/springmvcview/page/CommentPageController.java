package me.kolganov.springmvcview.page;

import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.domain.Comment;
import me.kolganov.springmvcview.service.BookService;
import me.kolganov.springmvcview.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentPageController {
    private final CommentService commentService;
    private final BookService bookService;

    public CommentPageController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/comments")
    public String getPage(@RequestParam("book_id") long bookId, Model model) {
        List<Comment> comments = commentService.getAllByBookId(bookId);
        List<Book> books = bookService.getAll();

        model.addAttribute("bookId", bookId);
        model.addAttribute("comments", comments);
        model.addAttribute("books", books);
        return "comment";
    }
}
