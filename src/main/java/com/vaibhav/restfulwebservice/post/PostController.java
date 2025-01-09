package com.vaibhav.restfulwebservice.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    private final PostModelAssembler assembler;

    public PostController(PostService postService, PostModelAssembler assembler) {
        this.postService = postService;
        this.assembler = assembler;
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Post>> retrieveAllPosts() {
        List<EntityModel<Post>> allPosts = postService.findAll().stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(allPosts, linkTo(methodOn(this.getClass()).retrieveAllPosts()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Post> retrievePostById(@PathVariable int id) {
        Post post = postService.findByPostId(id);

        if (post == null) {
            throw new PostNotFoundException("No post found for id : " + id);
        }

        EntityModel<Post> entityModel = assembler.toModel(post);

        return entityModel;
    }

    @PostMapping("")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        EntityModel<Post> savedPost = assembler.toModel(postService.save(post));

        return ResponseEntity
                .created(savedPost.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedPost);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deletePost(@PathVariable int id) {
        postService.deletePostById(id);

        return ResponseEntity.noContent().build();
    }
}
