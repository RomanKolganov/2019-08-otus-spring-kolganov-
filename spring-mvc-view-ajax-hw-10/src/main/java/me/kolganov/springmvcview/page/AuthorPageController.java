package me.kolganov.springmvcview.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorPageController {
    @GetMapping(value = "/authors")
    public String getPage() {
        return "author";
    }
}
