package com.social.X.controller;

import com.social.X.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> createComment(@RequestParam("userID") int userId,
                                                @RequestParam("postID") int postId,
                                                @RequestParam("commentBody") String commentBody) {
        String response = commentService.createComment(userId, postId, commentBody);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> getCommentById(@RequestParam("commentID") int commentId) {
        return ResponseEntity.ok(commentService.getCommentById(commentId));
    }

    @PatchMapping
    public ResponseEntity<String> editComment(@RequestParam("commentID") int commentId,
                                              @RequestParam("commentBody") String commentBody) {
        String response = commentService.editComment(commentId, commentBody);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteComment(@RequestParam("commentID") int commentId) {
        String response = commentService.deleteComment(commentId);
        return ResponseEntity.ok(response);
    }
}
