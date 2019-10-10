package me.kolganov.libraryApp.shell;

import me.kolganov.libraryApp.domain.Author;
import me.kolganov.libraryApp.service.AuthorService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class AuthorShell {
    private final AuthorService service;

    public AuthorShell(AuthorService service) {
        this.service = service;
    }

    @ShellMethod(value = "Get all authors", key = {"get-all-authors", "gaa"})
    public String getAllAuthors() {
        return service.getAll();
    }

    @ShellMethod(value = "Get author by name", key = {"get-author-by-name", "ga"})
    public String getAuthorById(@ShellOption String name) {
        return service.getByName(name);
    }

    @ShellMethod(value = "Save new author", key = {"save-new-author", "sa"})
    public void saveNewAuthor(@ShellOption String name) {
        service.save(new Author(name));
    }

    @ShellMethod(value = "Update author by name", key = {"update-author", "ua"})
    public void updateAuthor(@ShellOption String oldName, String newName) {
        service.update(oldName, newName);
    }

    @ShellMethod(value = "Delete author by id", key = {"delete-author", "da"})
    public void deleteAuthorById(@ShellOption String id) {
        service.delete(id);
    }
}
