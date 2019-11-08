package me.kolganov.springmvcview.rest;

import me.kolganov.springmvcview.domain.Comment;
import me.kolganov.springmvcview.rest.dto.CommentDto;
import me.kolganov.springmvcview.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/comments/getAllComments", produces = "application/json")
    public List<CommentDto> getAllComments(@RequestParam("book_id") long bookId) {
        return commentService.getAllByBookId(bookId).stream().map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/comments/delete")
    public void delete(@RequestParam("id") long id) {
        commentService.delete(id);
    }

    @PostMapping(value = "/comments/create")
    public void createComment(@RequestParam("text") String text,
                              @RequestParam("book_id") long bookId) {
        commentService.save(new Comment(text), bookId);
    }

    @PutMapping(value = "/comments/update")
    public void updateComment(@RequestBody CommentDto commentDto) {
        commentService.update(new Comment(commentDto.getId(), commentDto.getText()), commentDto.getBookDto().getId());
    }
}
