package com.vaibhav.restfulwebservice.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    public List<Post> findByUserId(int userId);
}
