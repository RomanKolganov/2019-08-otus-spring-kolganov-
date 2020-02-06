package me.kolganov.springboothistryx.rest;

import lombok.RequiredArgsConstructor;
import me.kolganov.springboothistryx.domain.Comment;
import me.kolganov.springboothistryx.rest.dto.CommentDto;
import me.kolganov.springboothistryx.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

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
        commentService.save(Comment.builder().text(text).build(), bookId);
    }

    @PutMapping(value = "/comment/{id}")
    public void updateComment(@RequestBody CommentDto commentDto) {
        commentService.update(Comment.builder().id(commentDto.getId()).text(commentDto.getText()).build(),
                commentDto.getBookDto().getId());
    }
}
