package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genres")
    public String getAll(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        return "genre";
    }

    @PostMapping(value = "/genres/delete")
    public String delete(@RequestParam("id") long id) {
        genreService.delete(id);
        return "redirect:/genres";
    }

    @PostMapping(value = "/genres/create")
    public String create(@RequestParam("name") String name) {
        genreService.save(new Genre(name));
        return "redirect:/genres";
    }

    @GetMapping(value = "/genres/edit")
    public String getOne(@RequestParam("id") long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        return "genreEdit";
    }

    @PostMapping(value = "/genres/update")
    public String update(@RequestParam("id") long id, @RequestParam("name") String name) {
        genreService.update(new Genre(id, name));
        return "redirect:/genres";
    }
}
