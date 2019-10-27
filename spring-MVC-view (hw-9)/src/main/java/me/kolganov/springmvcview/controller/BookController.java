package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.AuthorService;
import me.kolganov.springmvcview.service.BookService;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;

    public BookController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Book> books = bookService.getAll();
        List<Author> authors = authorService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);

        return "book";
    }

    @RequestMapping(value = "/books/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") long id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/create", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name,
                         @RequestParam("author_id") long authorId,
                         @RequestParam("genre_id") long genreId) {
        bookService.save(new Book(name), authorId, genreId);
        return "redirect:/books";
    }

    @RequestMapping(value = "/books/edit", method = RequestMethod.GET)
    public String getOne(@RequestParam("id") long id, Model model) {
        Book book = bookService.getById(id);
        List<Author> authors = authorService.getAll();
        List<Genre> genres = genreService.getAll();

        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "bookEdit";
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id,
                         @RequestParam("name") String name,
                         @RequestParam("author_id") long authorId,
                         @RequestParam("genre_id") long genreId) {
        bookService.update(new Book(id, name), authorId, genreId);
        return "redirect:/books";
    }
}
