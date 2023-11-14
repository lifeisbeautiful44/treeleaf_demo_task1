package com.treeleaf.blog.comment.usecase;


import com.treeleaf.blog.post.repository.Post;

public class CommentResponseUseCase {

    private Post post;
    private String name;
    private String email;
    private String body;

    public CommentResponseUseCase() {
    }

    public CommentResponseUseCase(Post post, String name, String email, String body) {
        this.post = post;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommentResponseUseCase{" +
                "post=" + post +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
