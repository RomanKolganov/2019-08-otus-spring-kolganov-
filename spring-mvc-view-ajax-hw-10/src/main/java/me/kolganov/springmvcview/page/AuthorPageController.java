package me.kolganov.springmvcview.page;

import me.kolganov.springmvcview.domain.Author;
import me.kolganov.springmvcview.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AuthorPageController {
    private final AuthorService authorService;

    public AuthorPageController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/authors")
    public String getAll() {
        return "author";
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
