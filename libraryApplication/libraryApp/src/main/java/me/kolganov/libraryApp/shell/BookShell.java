package me.kolganov.libraryApp.shell;

import me.kolganov.libraryApp.domain.Book;
import me.kolganov.libraryApp.service.BookService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class BookShell {
    private final BookService bookService;

    public BookShell(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Get all books", key = {"get-all-books", "gab"})
    public String getAllBooks() {
        return bookService.getAll();
    }

    @ShellMethod(value = "Get book by id", key = {"get-boo-by-id", "gb"})
    public String getBookById(@ShellOption String id) {
        return bookService.getById(id);
    }

    @ShellMethod(value = "Delete book by id", key = {"delete-book", "db"})
    public void deleteBookById(@ShellOption String id) {
        bookService.delete(id);
    }

    @ShellMethod(value = "Save new book", key = {"save-book", "sb"})
    public void saveNewBook(@ShellOption String name, String authorId, String genreId) {
        bookService.save(new Book(name), authorId, genreId);
    }

    @ShellMethod(value = "Update book name", key = {"update-book-name", "ubn"})
    public void updateBookName(@ShellOption String id, String name) {
        bookService.save(new Book(id, name));
    }
}
