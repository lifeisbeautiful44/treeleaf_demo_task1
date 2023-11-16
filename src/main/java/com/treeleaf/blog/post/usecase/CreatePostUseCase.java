package com.treeleaf.blog.post.usecase;


import com.treeleaf.blog.post.repository.PostRespository;
import com.treeleaf.blog.post.repository.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreatePostUseCase {

    @Autowired
    private PostRespository postRespository;

    public Post savePost(Post post)
    {
       return postRespository.savePost(post);
    }

    public void updatePost(Post post , long postId)
    {
        postRespository.updatePost(post,postId);
    }

    public List<Post> findAllPost()
    {
       List<Post> posts =  postRespository.findAll();
       return posts;
    }

    public Post findByPostId(long postId)
    {
       Post post =  postRespository.findByPostId(postId);
       return post;
    }

    public String deletePost(long postId)
    {
        return  postRespository.delete(postId);
    }


}
