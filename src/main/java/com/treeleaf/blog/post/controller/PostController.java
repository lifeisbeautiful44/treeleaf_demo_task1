package com.treeleaf.blog.post.controller;


import com.treeleaf.blog.post.repository.Post;
import com.treeleaf.blog.post.usecase.CreatePostUseCase;
import com.treeleaf.blog.post.usecase.image.ImageStorageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Post> createPost(@RequestBody Post post)
    {
       Post savedPost =  createPostUseCase.savePost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.OK);

    }
    @PutMapping("{id}")
    public void updatePost(@RequestBody Post post , @PathVariable(name = "id") long postId)
    {
        createPostUseCase.updatePost(post,postId);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAllPost()
    {
      List<Post>  posts = createPostUseCase.findAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> findPostById(@PathVariable(name = "id") long postId)
    {
       Post post =  createPostUseCase.findByPostId(postId);
       return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name = "id") long postId)
    {
       String message =  createPostUseCase.deletePost(postId);
        return new ResponseEntity<>(message,HttpStatus.OK);

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
