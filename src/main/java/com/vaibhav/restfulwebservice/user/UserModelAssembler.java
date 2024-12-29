package com.vaibhav.restfulwebservice.user;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {

    @Override
    public EntityModel<User> toModel(User user) {
        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder usersLink = linkTo(methodOn(UserController.class).retrieveAllUsers());
        WebMvcLinkBuilder selfLink = linkTo(methodOn(UserController.class).retrieveUser(user.getId()));

        entityModel.add(selfLink.withSelfRel(), usersLink.withRel("users"));

        return entityModel;
    }
}
