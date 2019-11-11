package me.kolganov.springmvcview.rest;

import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.rest.dto.GenreDto;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

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
        genreService.save(new Genre(name));
    }

    @PutMapping(value = "/genre/{id}")
    public void updateGenre(@RequestBody GenreDto genreDto) {
        genreService.update(GenreDto.toEntity(genreDto));
    }
}
