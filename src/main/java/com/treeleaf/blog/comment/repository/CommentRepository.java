package com.treeleaf.blog.comment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveComment(Comment comment, long postId)
    {
        String saveCommentQuery = "INSERT INTO comment (post_id, name,email,body) values(?,?,?,?)";
        jdbcTemplate.update(saveCommentQuery, postId, comment.getName(), comment.getEmail(), comment.getBody());

    }



}
