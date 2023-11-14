package com.treeleaf.blog.comment.usecase;

import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentUseCase {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment, long postId)
    {
        commentRepository.saveComment(comment,postId);
    }
}
