package me.kolganov.springmvcview.page;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.AuthorService;
import me.kolganov.springmvcview.service.BookService;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookPageController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookPageController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping(value = "/books")
    public String getPage(Model model) {
        List<Book> books = bookService.getAll();
        List<Author> authors = authorService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);

        return "book";
    }
}
