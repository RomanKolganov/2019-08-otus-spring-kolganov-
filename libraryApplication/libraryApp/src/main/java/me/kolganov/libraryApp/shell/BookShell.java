package me.kolganov.libraryApp.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class BookShell {

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public String getAllBooks() {
        return "books";
    }
}
