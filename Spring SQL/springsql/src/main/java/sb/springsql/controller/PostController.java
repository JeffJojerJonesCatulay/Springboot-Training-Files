package sb.springsql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sb.springsql.entity.Post;
import sb.springsql.service.PostService;

import java.util.List;

@RequestMapping("/api/posts")
@RestController
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping
    public List<Post> getAllPost(){
        return service.getAllPost();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable("id") Long id){
        return service.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return service.createPost(post);
    }
}
