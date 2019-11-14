package me.kolganov.springsecurityformbased.hw11.controller;

import me.kolganov.springsecurityformbased.hw11.domain.Author;
import me.kolganov.springsecurityformbased.hw11.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public String getAll(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "author";
    }

    @PostMapping(value = "/authors/delete")
    public String delete(@RequestParam("id") long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @PostMapping(value = "/authors/create")
    public String create(@RequestParam("name") String name) {
        authorService.save(new Author(name));
        return "redirect:/authors";
    }

    @GetMapping(value = "/authors/edit")
    public String getOne(@RequestParam("id") long id, Model model) {
        Author author = authorService.getById(id);
        model.addAttribute("author", author);
        return "authorEdit";
    }

    @PostMapping(value = "/authors/update")
    public String update(@RequestParam("id") long id, @RequestParam("name") String name) {
        authorService.update(new Author(id, name));
        return "redirect:/authors";
    }
}
