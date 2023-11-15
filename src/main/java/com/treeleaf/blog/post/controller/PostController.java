package com.treeleaf.blog.post.controller;


import com.treeleaf.blog.post.repository.Post;
import com.treeleaf.blog.post.usecase.CreatePostUseCase;
import com.treeleaf.blog.post.usecase.image.ImageStorageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
  private  CreatePostUseCase createPostUseCase;

    @Autowired
    private ImageStorageUseCase imageStorageUseCase;

    @Value("${blog.image.dir}")
    private String path;


    @PostMapping
    public void createPost(@RequestBody Post post)
    {
        createPostUseCase.savePost(post);
        System.out.println("Post has been successfully created..");
    }


    @PutMapping("{id}")
    public void updatePost(@RequestBody Post post , @PathVariable(name = "id") long postId)
    {
        System.out.println(postId);
        System.out.println(post);
        createPostUseCase.updatePost(post,postId);
    }

    @GetMapping
    public void findAllPost()
    {
      List<Post>  posts = createPostUseCase.findAllPost();

        System.out.println(posts);
    }

    @GetMapping("{id}")
    public void findPostById(@PathVariable(name = "id") long postId)
    {
       Post post =  createPostUseCase.findByPostId(postId);
        System.out.println(post);
    }

    @DeleteMapping("{id}")
    public void deletePostById(@PathVariable(name = "id") long postId)
    {
         createPostUseCase.deletePost(postId);
    }


    @PostMapping("/upload/image/{postId}")
    public void uploadImage(@RequestParam("image")MultipartFile image, @PathVariable(name = "postId")long postId)
    {
     String imageName = imageStorageUseCase.uploadImage(path,image);
     Post post = createPostUseCase.findByPostId(postId);
     post.setImageName(imageName);
     createPostUseCase.updatePost(post,postId);
    }


}
