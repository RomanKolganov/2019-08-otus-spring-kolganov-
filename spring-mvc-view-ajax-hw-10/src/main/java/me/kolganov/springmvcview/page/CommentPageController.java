package me.kolganov.springmvcview.page;

import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentPageController {
    private final BookService bookService;

    public CommentPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/comments")
    public String getPage(@RequestParam("book_id") long bookId, Model model) {
        List<Book> books = bookService.getAll();

        model.addAttribute("bookId", bookId);
        model.addAttribute("books", books);
        return "comment";
    }
}
