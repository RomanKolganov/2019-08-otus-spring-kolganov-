package me.kolganov.springactuator.rest;

import me.kolganov.springactuator.domain.Comment;
import me.kolganov.springactuator.rest.dto.CommentDto;
import me.kolganov.springactuator.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/comment/{book_id}", produces = "application/json")
    public List<CommentDto> getAllComments(@PathVariable("book_id") long bookId) {
        return commentService.getAllByBookId(bookId).stream().map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/comment/{id}")
    public void delete(@PathVariable("id") long id) {
        commentService.delete(id);
    }

    @PostMapping(value = "/comment/")
    public void createComment(@RequestParam("text") String text,
                              @RequestParam("book_id") long bookId) {
        commentService.save(new Comment(text), bookId);
    }

    @PutMapping(value = "/comment/{id}")
    public void updateComment(@RequestBody CommentDto commentDto) {
        commentService.update(new Comment(commentDto.getId(), commentDto.getText()), commentDto.getBookDto().getId());
    }
}
