package me.kolganov.springsecurityaclhw12.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorPageController {
    @GetMapping(value = "/authors")
    public String getPage() {
        return "author";
    }
}
