package me.kolganov.springboothistryx.page;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.domain.Author;
import me.kolganov.springboothistryx.domain.Book;
import me.kolganov.springboothistryx.domain.Genre;
import me.kolganov.springboothistryx.service.AuthorService;
import me.kolganov.springboothistryx.service.BookService;
import me.kolganov.springboothistryx.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookPageController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

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
