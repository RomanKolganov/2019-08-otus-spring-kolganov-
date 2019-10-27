package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        return "genre";
    }

    @RequestMapping(value = "/genres/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        genreService.delete(id);
        return "redirect:/genres";
    }

    @RequestMapping(value = "/genres/create", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name) {
        genreService.save(new Genre(name));
        return "redirect:/genres";
    }

    @RequestMapping(value = "/genres/edit", method = RequestMethod.GET)
    public String getOne(@RequestParam("id") long id, Model model) {
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        return "genreEdit";
    }

    @RequestMapping(value = "/genres/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("name") String name) {
        genreService.update(new Genre(id, name));
        return "redirect:/genres";
    }
}
