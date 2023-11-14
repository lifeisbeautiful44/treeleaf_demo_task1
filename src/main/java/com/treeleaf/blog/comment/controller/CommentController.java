package com.treeleaf.blog.comment.controller;


import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.comment.usecase.CommentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
public class CommentController {

    @Autowired
    private CommentUseCase commentUseCase;

    @PostMapping("{id}/comment")
    public void createComment(@PathVariable(name = "id") long postId, @RequestBody Comment comment)
    {
        commentUseCase.saveComment(comment,postId);
        System.out.println("Comment has been successfully added ");
    }
}
