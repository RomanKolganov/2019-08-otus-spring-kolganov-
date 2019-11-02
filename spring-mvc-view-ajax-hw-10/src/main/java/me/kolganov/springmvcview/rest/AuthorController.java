package me.kolganov.springmvcview.rest;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.rest.dto.AuthorDto;
import me.kolganov.springmvcview.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors/getAllAuthors", produces = "application/json")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAll().stream().map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/authors/delete")
    public void deleteAuthor(@RequestParam("id") long id) {
        authorService.delete(id);
    }

    @PostMapping("/authors/create")
    public void createAuthor(@RequestParam("name") String name) {
        authorService.save(new Author(name));
    }

    @PutMapping(value = "/authors/update")
    public void update(@RequestBody AuthorDto authorDto) {
        authorService.update(AuthorDto.toEntity(authorDto));
    }
}
