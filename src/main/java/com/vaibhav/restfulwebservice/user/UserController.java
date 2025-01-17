package com.vaibhav.restfulwebservice.user;

import com.vaibhav.restfulwebservice.post.Post;
import com.vaibhav.restfulwebservice.post.PostModelAssembler;
import com.vaibhav.restfulwebservice.post.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDAOService userDAOService;
    private final UserModelAssembler assembler;
    private final PostService postService;
    private final PostModelAssembler postModelAssembler;

    public UserController(UserDAOService userDAOService, UserModelAssembler assembler, PostService postService, PostModelAssembler postModelAssembler) {
        this.userDAOService = userDAOService;
        this.assembler = assembler;
        this.postService = postService;
        this.postModelAssembler = postModelAssembler;
    }

    // GET /api/users
    @GetMapping("")
    public CollectionModel<EntityModel<User>> retrieveAllUsers() {

        List<EntityModel<User>> users = userDAOService.findAll()
                .stream()
                .map(assembler::toModel)
                .toList();

        return CollectionModel.of(users, linkTo(methodOn(this.getClass()).retrieveAllUsers()).withSelfRel());
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = userDAOService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("No user found for id : " + id);
        }

        return assembler.toModel(user);
    }

    // POST /api/users
    @PostMapping("")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
//        User savedUser = userDAOService.save(user);

        EntityModel<User> savedUser = assembler.toModel(userDAOService.save(user));

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();

        return ResponseEntity
                .created(savedUser.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userDAOService.deleteUserById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public CollectionModel<EntityModel<Post>> retrieveAllPostsByUsers(@PathVariable int id) {

        if (userDAOService.findOne(id) == null) {
            throw new UserNotFoundException("No user found for id : " + id);
        }

        List<EntityModel<Post>> posts = postService.findAllByUser(id)
                .stream()
                .map(postModelAssembler::toModel)
                .toList();

        return CollectionModel.of(posts, linkTo(methodOn(this.getClass()).retrieveAllUsers()).withSelfRel());
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<?> createPostForUser(@PathVariable int id, @RequestBody Post post) {
        User user = userDAOService.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("No user found for id : " + id);
        }

        post.setUser(user);
        EntityModel<Post> savedPost = postModelAssembler.toModel(postService.save(post));

        return ResponseEntity
                .created(savedPost.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(savedPost);
    }
}
