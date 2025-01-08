package com.vaibhav.restfulwebservice.post;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findByPostId(int postId) {
        return postRepository.findById(postId)
                .orElse(null);
    }

    public List<Post> findAllByUser(int userId) {
        return postRepository.findByUserId(userId);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void deletePostById(int postId) {
        postRepository.deleteById(postId);
    }
}
