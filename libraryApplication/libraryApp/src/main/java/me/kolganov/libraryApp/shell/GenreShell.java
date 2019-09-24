package me.kolganov.libraryApp.shell;

import me.kolganov.libraryApp.domain.Genre;
import me.kolganov.libraryApp.service.GenreService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GenreShell {
    private final GenreService genreService;

    public GenreShell(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(value = "Get all genres", key = {"get-all-genres", "gag"})
    public String getAllGenres() {
        return genreService.getAll();
    }

    @ShellMethod(value = "Get genre by id", key = {"get-genre-by-id", "gg"})
    public String getGenreById(@ShellOption long id) {
        return genreService.getById(id);
    }

    @ShellMethod(value = "Save new genre", key = {"save-new-genre", "sg"})
    public void saveNewGenre(@ShellOption String name) {
        genreService.create(name);
    }

    @ShellMethod(value = "Update genre by id", key = {"update-genre", "ug"})
    public void updateGenre(@ShellOption long id, String name) {
        genreService.update(new Genre(id, name));
    }

    @ShellMethod(value = "Delete genre by id", key = {"delete-genre", "dg"})
    public void deleteGenreById(@ShellOption long id) {
        genreService.delete(id);
    }
}
