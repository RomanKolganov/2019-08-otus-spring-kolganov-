package me.kolganov.springmvcview.controller;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/authors/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/authors/create", method = RequestMethod.POST)
    public String create(@RequestParam("name") String name) {
        authorService.save(new Author(name));
        return "redirect:/authors";
    }

    @RequestMapping(value = "/authors/edit", method = RequestMethod.GET)
    public String getOne(@RequestParam("id") long id, Model model) {
        Author author = authorService.getById(id);
        model.addAttribute("author", author);
        return "authorEdit";
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("name") String name) {
        authorService.update(new Author(id, name));
        return "redirect:/authors";
    }
}
