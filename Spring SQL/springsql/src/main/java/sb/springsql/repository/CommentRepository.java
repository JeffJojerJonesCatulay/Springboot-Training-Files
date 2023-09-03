package sb.springsql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.springsql.entity.Comment;

import java.util.List;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
    // add additional method to find the post by id which the comment will be put
    List<Comment> findByPostId(Long postId);
}
