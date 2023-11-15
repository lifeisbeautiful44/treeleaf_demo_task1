package com.treeleaf.blog.post.repository;

import com.treeleaf.blog.post.usecase.image.ImageStorageUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public class PostRespository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ImageStorageUseCase imageStorageUseCase;


    public void savePost(Post post) {
        String sql = "INSERT INTO post (title, description) VALUES (?, ?)";
        jdbcTemplate.update(sql,post.getTitle(),post.getDescription());

    }

    public void updatePost(Post post , long postId)
    {
        Post savedPreviousPost = findByPostId(postId);

        if(post.getTitle() == null)
        {
            post.setTitle(savedPreviousPost.getTitle());
        }
        if(post.getDescription() == null)
        {
            post.setDescription(savedPreviousPost.getDescription());
        }


        if(post.getImageName() == null)
        {
            post.setImageName(savedPreviousPost.getImageName());
        }

        String sql = "UPDATE post SET title = ?, description = ? , imageName = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, post.getTitle(), post.getDescription(), post.getImageName(), postId);

        System.out.println("Rows affected by update: " + rowsAffected);

    }

    public Post findByPostId(long postId)
    {
        String sql = "SELECT * FROM post WHERE id = ?";
        PostRowMapper rowMapper = new PostRowMapper();
        Post post = jdbcTemplate.queryForObject(sql, rowMapper, postId);

        return post;
    }
    public List<Post> findAll() {
        String sql = "SELECT * FROM post";
        List<Post> posts = jdbcTemplate.query(sql, new PostRowMapper());

        return posts;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM post WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
