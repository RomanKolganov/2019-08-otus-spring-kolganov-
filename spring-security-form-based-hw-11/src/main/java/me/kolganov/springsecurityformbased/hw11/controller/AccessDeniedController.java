package me.kolganov.springsecurityformbased.hw11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class AccessDeniedController {
    @RequestMapping(value = "/access_denied")
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            String message = "Привет, " + principal.getName() + ", у тебя нет таких полномочий!";
            model.addAttribute("message", message);
        } else {
            String message = "Привет, у тебя нет таких полномочий!";
            model.addAttribute("message", message);
        }
        return "accessDenied";
    }
}
