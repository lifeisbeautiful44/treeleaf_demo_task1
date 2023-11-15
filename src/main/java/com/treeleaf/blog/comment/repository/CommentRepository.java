package com.treeleaf.blog.comment.repository;

import com.treeleaf.blog.comment.repository.rowmapper.CommentRowMapper;
import com.treeleaf.blog.comment.repository.rowmapper.CommentWithPostInfoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveComment(Comment comment, long postId)
    {
        String saveCommentQuery = "INSERT INTO comment (post_id, name,email,body) values(?,?,?,?)";
        jdbcTemplate.update(saveCommentQuery, postId, comment.getName(), comment.getEmail(), comment.getBody());

    }

    public List<Comment> findCommentsByPostId(long postId)
    {
        String sql =   " SELECT *  FROM comment  INNER JOIN post ON comment.post_id = post.id where post_id = ? ";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentWithPostInfoRowMapper(), postId);
        return comments;
    }

    public void updateComment(Comment comment , long commentId,  long postId)
    {
        Comment savedPreviousComment = findCommentByID(commentId);

        if (comment.getBody() !=null )
        {
            savedPreviousComment.setBody(comment.getBody());
        }


        String sql = "UPDATE comment SET body = ?, email = ?, name = ? WHERE id = ?";

        int rowsAffected = jdbcTemplate.update(
                sql,
                savedPreviousComment.getBody(),
                savedPreviousComment.getEmail(),
                savedPreviousComment.getName(),
                commentId
        );
        System.out.println("Rows affected" + rowsAffected);

    }

    private Comment findCommentByID(long commentId) {
        String sql = "select * from comment where id = ?";
        CommentRowMapper commentRowMapper = new CommentRowMapper() ;
        Comment comment = jdbcTemplate.queryForObject(sql, commentRowMapper, commentId);
        return comment;
    }


    public void delete(Long commentId) {
        String sql = "DELETE FROM comment WHERE id = ?";
        jdbcTemplate.update(sql, commentId);
    }

}
