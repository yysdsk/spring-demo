package com.example.demo.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
//UserInfoDaoはコンポーネント
public class UserDao {

    private JdbcTemplate jdbc;

    public UserDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        return jdbc.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
    }

    public Map<String, Object> findById(String id) {
        return jdbc.queryForMap("SELECT * FROM user WHERE id = ?", id);
    }

//    public User findUserBeanPropertyById(String id) {
//        try {
//            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//            return jdbc.queryForObject("SELECT * FROM user WHERE id = ?", rowMapper, id);
//        } catch (EmptyResultDataAccessExんception e) {
//            System.out.println("IDがありませ");
//            return null;
//        }
//    }

    public User findUserBeanPropertyById(String id) {
            RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
            return jdbc.queryForObject("SELECT * FROM user WHERE id = ?", rowMapper, id);
    }

    public int insert(User user) {
        return jdbc.update(
                "INSERT INTO user VALUES (?, ?, ?, CURRENT_TIMESTAMP)",
                user.getId(),
                user.getName(),
                user.getDept()
        );
    }

    public int update(User user) {
        return jdbc.update(
                "UPDATE user SET (name, dept) = (?, ?) WHERE id = ?",
                user.getName(),
                user.getDept(),
                user.getId()
        );
    }

    public int deleteById(String id) {
        return jdbc.update("DELETE FROM user WHERE id  = ?", id);
    }

}
