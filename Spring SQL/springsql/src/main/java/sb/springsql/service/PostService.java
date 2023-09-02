package sb.springsql.service;

import org.springframework.stereotype.Service;
import sb.springsql.entity.Post;

import java.util.List;

@Service
public interface PostService {
    // interface methods
    Post createPost(Post post);
    List<Post> getAllPost();
    Post getPostById(long id);
    void updatePost(long id, Post post);
    void deletePost(long id);
}
