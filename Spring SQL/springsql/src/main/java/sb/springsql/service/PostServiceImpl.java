package sb.springsql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.springsql.entity.Post;
import sb.springsql.repository.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    // create instance of repository
    @Autowired
    private PostRepository repository;

    @Override
    public Post createPost(Post post) {
        return repository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return repository.findAll();
    }

    @Override
    public Post getPostById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void updatePost(long id, Post post) {

    }

    @Override
    public void deletePost(long id) {

    }
}
