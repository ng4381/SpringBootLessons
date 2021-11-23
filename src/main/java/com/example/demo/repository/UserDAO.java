package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.roommaper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql, userMapper);
        return users;
    }

    public void createUser(User user) {
        String sql = "insert into user values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, user.getId());
                ps.setString(2, user.getName());
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, user.getOrganization_id());
            }
        });
    }

    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        });
    }
}
