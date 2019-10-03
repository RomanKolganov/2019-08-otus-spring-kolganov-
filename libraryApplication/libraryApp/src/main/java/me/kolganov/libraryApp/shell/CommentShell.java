package me.kolganov.libraryApp.shell;

import me.kolganov.libraryApp.domain.Comment;
import me.kolganov.libraryApp.service.CommentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class CommentShell {
    private final CommentService commentService;

    public CommentShell(CommentService commentService) {
        this.commentService = commentService;
    }

    @ShellMethod(value = "Get all Comments", key = {"get-all-comments", "gac"})
    public String getAllComments() {
        return commentService.getAll();
    }

    @ShellMethod(value = "Get comment by id", key = {"get-comment", "gc"})
    public String getCommentById(@ShellOption long id) {
        return commentService.getById(id);
    }

    @ShellMethod(value = "Save new Comment to Book", key = {"save-comment", "sc"})
    public void saveNewComment(@ShellOption String text, long bookId) {
        commentService.save(new Comment(text), bookId);
    }

    @ShellMethod(value = "Delete comment by id", key = {"delete-comment", "dc"})
    public void deleteCommentById(@ShellOption long id) {
        commentService.delete(id);
    }
}
