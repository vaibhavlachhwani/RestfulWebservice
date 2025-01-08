package com.vaibhav.restfulwebservice.post;

import org.hibernate.sql.results.graph.entity.internal.EntityAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {
    @Override
    public EntityModel<Post> toModel(Post post) {
        EntityModel<Post> entityModel = EntityModel.of(post);

        WebMvcLinkBuilder allPosts = linkTo(methodOn(PostController.class).retrieveAllPosts());
        WebMvcLinkBuilder self = linkTo(methodOn(PostController.class).retrievePostById(post.getId()));

        entityModel.add(allPosts.withRel("posts"),
                self.withSelfRel());

        return entityModel;
    }
}
