package me.kolganov.springboothistryx.rest;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.domain.Genre;
import me.kolganov.springboothistryx.rest.dto.GenreDto;
import me.kolganov.springboothistryx.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping(value = "/genre/", produces = "application/json")
    public List<GenreDto> getAllGenres() {
        return genreService.getAll().stream().map(GenreDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/genre/{id}")
    public void deleteGenre(@PathVariable("id") long id) {
        genreService.delete(id);
    }

    @PostMapping(value = "/genre/")
    public void createGenre(@RequestParam("name") String name) {
        genreService.save(Genre.builder().name(name).build());
    }

    @PutMapping(value = "/genre/{id}")
    public void updateGenre(@RequestBody GenreDto genreDto) {
        genreService.update(GenreDto.toEntity(genreDto));
    }
}
