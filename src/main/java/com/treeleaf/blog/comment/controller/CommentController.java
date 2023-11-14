package com.treeleaf.blog.comment.controller;


import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.comment.usecase.CommentResponseUseCase;
import com.treeleaf.blog.comment.usecase.CommentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}/comment")
    public ResponseEntity<List<CommentResponseUseCase>> findCommentByPostId(@PathVariable(name = "id") long postId)
    {
        List<CommentResponseUseCase> commentByPostId = commentUseCase.findCommentByPostId(postId);
        return new ResponseEntity<>(commentByPostId, HttpStatus.OK);
    }

    @PutMapping("{postId}/comment/{commentId}")
    public void updateComment(@PathVariable(name = "postId") long postId,
                              @RequestBody Comment comment,
                              @PathVariable(name = "commentId")long commentId)
    {
        commentUseCase.updateComment(comment,commentId,postId);
        System.out.println("Update Comment");
    }

    @DeleteMapping("{postId}/comment/{commentId}")
    public void deleteComment(@PathVariable(name = "postId") long postId,
                              @RequestBody Comment comment,
                              @PathVariable(name = "commentId")long commentId)
    {
        commentUseCase.deleteComment(commentId);
        System.out.println("Deleted Comment");
    }
}
