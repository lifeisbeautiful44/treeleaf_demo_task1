package com.treeleaf.blog.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private  JdbcTemplate jdbcTemplate;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("USER");
        }

        String sql = "INSERT INTO user (user_name, password, role) VALUES (?, ?, ?)";
      //  jdbcTemplate.update(sql, user.getUserName(), passwordEncoder.encode(user.getPassword()), user.getRole());
        jdbcTemplate.update(sql, user.getUserName(), user.getPassword(), user.getRole());

    }

    public User findByUserName(String userName)
    {
        String sql = "SELECT * FROM user WHERE username = ?";
        UserRowMapper rowMapper =  new UserRowMapper();

        User user = jdbcTemplate.queryForObject(sql, rowMapper, userName);
        return user;
    }


}
