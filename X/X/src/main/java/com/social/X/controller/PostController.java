package com.social.X.controller;

import com.social.X.model.Post;
import com.social.X.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@RequestParam("userID") int userId, @RequestParam("postBody") String postBody) {
        String response = postService.createPost(userId, postBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getPostById(@RequestParam("postID") int postId) {
        return ResponseEntity.ok(postService.getPostById(postId));
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserFeed() {
        List<Post> posts = postService.getAllPostsSortedByDate(); // Retrieve all posts sorted by date
        return ResponseEntity.ok(posts);
    }

    @PatchMapping
    public ResponseEntity<String> editPost(@RequestParam("postID") int postId, @RequestParam("postBody") String postBody) {
        String response = postService.editPost(postId, postBody);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam("postID") int postId) {
        String response = postService.deletePost(postId);
        return ResponseEntity.ok(response);
    }
}
