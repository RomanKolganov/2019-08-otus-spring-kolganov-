package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.domain.Comment;
import me.kolganov.springmvcview.service.BookService;
import me.kolganov.springmvcview.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public String getAll(@RequestParam("book_id") long bookId, Model model) {
        List<Comment> comments = commentService.getAllByBookId(bookId);
        model.addAttribute("bookId", bookId);
        model.addAttribute("comments", comments);
        return "comment";
    }

    @RequestMapping(value = "/comments/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("book_id") long bookId,
                         @RequestParam("id") long id) {
        commentService.delete(id);
        return "redirect:/comments?book_id="+bookId;
    }

    @RequestMapping(value = "/comments/create", method = RequestMethod.POST)
    public String create(@RequestParam("text") String text,
                         @RequestParam("book_id") long bookId) {
        commentService.save(new Comment(text), bookId);
        return "redirect:/comments?book_id="+bookId;
    }

    @RequestMapping(value = "/comments/edit", method = RequestMethod.GET)
    public String getOne(@RequestParam("id") long id, Model model) {
        Comment comment = commentService.getById(id);
        List<Book> books = bookService.getAll();

        model.addAttribute("comment", comment);
        model.addAttribute("books", books);
        return "commentEdit";
    }

    @RequestMapping(value = "/comments/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id,
                         @RequestParam("text") String text,
                         @RequestParam("book_id") long bookId) {
        commentService.update(new Comment(id, text), bookId);
        return "redirect:/comments?book_id="+bookId;
    }
}
