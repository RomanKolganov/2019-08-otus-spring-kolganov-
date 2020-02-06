package me.kolganov.springboothistryx.rest;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.domain.Author;
import me.kolganov.springboothistryx.rest.dto.AuthorDto;
import me.kolganov.springboothistryx.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping(value = "/author/", produces = "application/json")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAll().stream().map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable("id") long id) {
        authorService.delete(id);
    }

    @PostMapping("/author/")
    public void createAuthor(@RequestParam("name") String name) {
        authorService.save(Author.builder().name(name).build());
    }

    @PutMapping(value = "/author/{id}")
    public void updateAuthor(@RequestBody AuthorDto authorDto) {
        authorService.update(AuthorDto.toEntity(authorDto));
    }
}
