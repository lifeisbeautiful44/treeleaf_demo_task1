package com.treeleaf.blog.post.repository;


import jakarta.annotation.Nullable;

public class Post {

    private long id;
    private String title;
    private String description;

    private String imageName;

    public Post(long id, String title, String description, String imageName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageName = imageName;
    }

    public Post()
    {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
