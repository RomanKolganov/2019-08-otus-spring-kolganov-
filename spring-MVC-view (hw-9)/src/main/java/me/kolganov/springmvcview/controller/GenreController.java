package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Genre;
import me.kolganov.springmvcview.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
