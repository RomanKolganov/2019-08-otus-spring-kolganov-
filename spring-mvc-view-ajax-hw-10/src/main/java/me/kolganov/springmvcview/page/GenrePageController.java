package me.kolganov.springmvcview.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenrePageController {
    @GetMapping(value = "/genres")
    public String getPage() {
        return "genre";
    }
}
