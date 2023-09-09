package sb.springsql.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.springsql.entity.Comment;
import sb.springsql.entity.Post;
import sb.springsql.payload.CommentDto;
import sb.springsql.repository.CommentRepository;
import sb.springsql.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);
        return mapToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException();
        }
        return mapToDto(comment);
    }

    @Override
    public CommentDto updateComment(long postId, long commentId, CommentDto commentUpdate) {
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException();
        }
        comment.setName(commentUpdate.getName());
        comment.setEmail(commentUpdate.getEmail());
        comment.setBody(commentUpdate.getBody());

        Comment updatedComment = commentRepository.save(comment);
        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(long postId, long commentId) {
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        if(!comment.getPost().getId().equals(post.getId())){
            throw new RuntimeException();
        }
        commentRepository.delete(comment);
    }

    public CommentDto mapToDto(Comment comment){
        return mapper.map(comment, CommentDto.class);
    }

    public Comment mapToEntity(CommentDto commentDto){
        return mapper.map(commentDto, Comment.class);
    }
}
