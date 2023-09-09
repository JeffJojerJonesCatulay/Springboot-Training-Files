package sb.springsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.springsql.entity.Comment;
import sb.springsql.payload.CommentDto;
import sb.springsql.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/post/")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable("postId") long postId,
                                                    @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(service.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable("postId") long postId){
        return service.getCommentByPostId(postId);
    }

    @GetMapping("{postId}/comments/{id}")
    public ResponseEntity<CommentDto> getCommentsById(@PathVariable("postId") long postId,
    @PathVariable("id") long commentId){
        CommentDto commentDto = service.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable("postId") long postId,
            @PathVariable("commentId") long commentId,
            @RequestBody CommentDto commentDto){
        CommentDto updatedComment = service.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(
            @PathVariable("postId") long postId,
            @PathVariable("commentId") long commentId
            )
    {
        service.deleteComment(postId, commentId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
