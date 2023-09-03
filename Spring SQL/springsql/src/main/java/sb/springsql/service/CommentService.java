package sb.springsql.service;

import org.springframework.stereotype.Service;
import sb.springsql.entity.Comment;
import sb.springsql.payload.CommentDto;

@Service
public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
}
