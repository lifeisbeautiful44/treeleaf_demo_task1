package com.treeleaf.blog.comment.repository.rowmapper;


import com.treeleaf.blog.comment.repository.Comment;
import com.treeleaf.blog.post.repository.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentWithPostInfoRowMapper implements RowMapper<Comment> {


    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {

        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        comment.setName(rs.getString("name"));
        comment.setEmail(rs.getString("email"));
        comment.setBody(rs.getString("body"));

        Post post = new Post();
        post.setId(rs.getLong("post_id"));
        post.setTitle(rs.getString("title"));
        post.setDescription(rs.getString("description"));
        comment.setPost(post);

        return comment;
    }
}
