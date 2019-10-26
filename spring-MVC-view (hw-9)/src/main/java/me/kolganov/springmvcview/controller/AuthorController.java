package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "author";
    }
}
