package sb.springsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.springsql.entity.Comment;
import sb.springsql.payload.CommentDto;
import sb.springsql.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId,
                                                    @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(service.createComment(postId, commentDto), HttpStatus.CREATED);
    }
}
