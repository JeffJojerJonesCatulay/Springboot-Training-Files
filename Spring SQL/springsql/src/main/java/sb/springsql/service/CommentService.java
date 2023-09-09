package sb.springsql.service;

import org.springframework.stereotype.Service;
import sb.springsql.entity.Comment;
import sb.springsql.payload.CommentDto;

import java.util.List;

@Service
public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
    List<CommentDto> getCommentByPostId(long postId);
    CommentDto getCommentById(long postId, long commentId);
    CommentDto updateComment(long postId, long commentId, CommentDto commentDto);
    void deleteComment(long postId, long commentId);
}
