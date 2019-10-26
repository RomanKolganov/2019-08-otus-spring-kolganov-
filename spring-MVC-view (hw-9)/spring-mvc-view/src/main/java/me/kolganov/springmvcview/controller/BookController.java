package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "book";
    }
}
