package com.social.X.model;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String commentBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public void setUser(User user) {
        this.user = user;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }
    public int getId() {
        return id;
    }
    public String getCommentBody() {
        return commentBody;
    }
    public User getUser() {
        return user;
    }
    public Post getPost() {
        return post;
    }

}
