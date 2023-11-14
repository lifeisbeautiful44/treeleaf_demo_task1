package com.treeleaf.blog.comment.usecase;

import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.comment.repository.CommentRepository;
import com.treeleaf.blog.comment.usecase.converter.CommentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentUseCase {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment, long postId)
    {
        commentRepository.saveComment(comment,postId);
    }

    public List<CommentResponseUseCase>  findCommentByPostId(long postId){
        List<Comment> commentsByPostId = commentRepository.findCommentsByPostId(postId);

        List<CommentResponseUseCase> commentResponseUseCases = CommentConverter.MapEntityToCommentResponse(commentsByPostId);
        return commentResponseUseCases;
    }

    public void updateComment(Comment comment , long commentId, long postId)
    {
        commentRepository.updateComment(comment,commentId,postId);
    }

    public void deleteComment(long commentId)
    {
        commentRepository.delete(commentId);
    }
}
