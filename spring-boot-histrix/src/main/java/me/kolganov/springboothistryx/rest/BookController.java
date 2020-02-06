package me.kolganov.springboothistryx.rest;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.domain.Book;
import me.kolganov.springboothistryx.rest.dto.BookDto;
import me.kolganov.springboothistryx.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping(value = "/book/", produces = "application/json")
    public List<BookDto> getAllBooks() {
        return bookService.getAll().stream().map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/book/{id}")
    public void delete(@PathVariable("id") long id) {
        bookService.delete(id);
    }

    @PostMapping(value = "/book/")
    public void create(@RequestParam("name") String name,
                       @RequestParam("author_id") long authorId,
                       @RequestParam("genre_id") long genreId) {
        bookService.save(Book.builder().name(name).build(), authorId, genreId);
    }

    @PutMapping(value = "/book/{id}")
    public void update(@RequestBody BookDto bookDto) {
        bookService.update(Book.builder().id(bookDto.getId()).name(bookDto.getName()).build(),
                bookDto.getAuthorDto().getId(),
                bookDto.getGenreDto().getId());
    }
}
