package me.kolganov.springsecurityformbased.hw11.controller;

import me.kolganov.springsecurityformbased.hw11.domain.Book;
import me.kolganov.springsecurityformbased.hw11.domain.Comment;
import me.kolganov.springsecurityformbased.hw11.service.BookService;
import me.kolganov.springsecurityformbased.hw11.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommentController {
    private final CommentService commentService;
    private final BookService bookService;

    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @GetMapping(value = "/comments")
    public String getAll(@RequestParam("book_id") long bookId, Model model) {
        List<Comment> comments = commentService.getAllByBookId(bookId);
        model.addAttribute("bookId", bookId);
        model.addAttribute("comments", comments);
        return "comment";
    }

    @PostMapping(value = "/comments/delete")
    public String delete(@RequestParam("book_id") long bookId,
                         @RequestParam("id") long id) {
        commentService.delete(id);
        return "redirect:/comments?book_id="+bookId;
    }

    @PostMapping(value = "/comments/create")
    public String create(@RequestParam("text") String text,
                         @RequestParam("book_id") long bookId) {
        commentService.save(new Comment(text), bookId);
        return "redirect:/comments?book_id="+bookId;
    }

    @GetMapping(value = "/comments/edit")
    public String getOne(@RequestParam("id") long id, Model model) {
        Comment comment = commentService.getById(id);
        List<Book> books = bookService.getAll();

        model.addAttribute("comment", comment);
        model.addAttribute("books", books);
        return "commentEdit";
    }

    @PostMapping(value = "/comments/update")
    public String update(@RequestParam("id") long id,
                         @RequestParam("text") String text,
                         @RequestParam("book_id") long bookId) {
        commentService.update(new Comment(id, text), bookId);
        return "redirect:/comments?book_id="+bookId;
    }
}
