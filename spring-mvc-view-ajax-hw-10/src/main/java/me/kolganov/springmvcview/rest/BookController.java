package me.kolganov.springmvcview.rest;

import me.kolganov.springmvcview.domain.Book;
import me.kolganov.springmvcview.rest.dto.BookDto;
import me.kolganov.springmvcview.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books/getAllBooks", produces = "application/json")
    public List<BookDto> getAllBooks() {
        return bookService.getAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/books/delete")
    public void delete(@RequestParam("id") long id) {
        bookService.delete(id);
    }

    @PostMapping(value = "/books/create")
    public void create(@RequestParam("name") String name,
                       @RequestParam("author_id") long authorId,
                       @RequestParam("genre_id") long genreId) {
        bookService.save(new Book(name), authorId, genreId);
    }

    @PutMapping(value = "/books/update")
    public void update(@RequestBody BookDto bookDto) {
        bookService.update(new Book(bookDto.getId(),
                bookDto.getName()),
                bookDto.getAuthorDto().getId(),
                bookDto.getGenreDto().getId());
    }
}
