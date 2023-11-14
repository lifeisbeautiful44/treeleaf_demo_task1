package com.treeleaf.blog.comment.usecase.converter;

import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.comment.usecase.CommentResponseUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    public static List<CommentResponseUseCase> MapEntityToCommentResponse(List<Comment> comments )
    {
        return comments.stream()
                .map(comment -> {
                    CommentResponseUseCase commentResponse = new CommentResponseUseCase();
                    commentResponse.setName(comment.getName());
                    commentResponse.setPost(comment.getPost());
                    commentResponse.setBody(comment.getBody());
                    commentResponse.setEmail(comment.getEmail());
                    return commentResponse;
                })
                .collect(Collectors.toList());

    }
}
