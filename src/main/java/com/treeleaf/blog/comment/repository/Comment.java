package com.treeleaf.blog.comment.repository;
import com.treeleaf.blog.post.repository.Post;

public class Comment {
    private long id;

    private Post post;
    private String name;
    private String email;
    private String body;

    public Comment()
    {

    }
    public Comment(long id, Post post, String name, String email, String body) {
        this.id = id;
        this.post = post;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Comment{" +
                "id=" + id +
                ", post=" + post +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
