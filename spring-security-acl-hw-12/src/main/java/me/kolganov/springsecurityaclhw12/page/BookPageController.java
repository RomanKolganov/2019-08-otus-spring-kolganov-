package me.kolganov.springsecurityaclhw12.page;

import me.kolganov.springsecurityaclhw12.domain.Author;
import me.kolganov.springsecurityaclhw12.domain.Book;
import me.kolganov.springsecurityaclhw12.domain.Genre;
import me.kolganov.springsecurityaclhw12.service.AuthorService;
import me.kolganov.springsecurityaclhw12.service.BookService;
import me.kolganov.springsecurityaclhw12.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
