package com.example.demo.hero;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDao {
    private JdbcTemplate jdbc;

    public HeroDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Hero> finAll() {
        return jdbc.query("SELECT * FROM hero", new BeanPropertyRowMapper<>(Hero.class));
    }

    public Hero findUserBeanPropertyById(String id) {
        RowMapper<Hero> rowMapper = new BeanPropertyRowMapper<>(Hero.class);
        return jdbc.queryForObject("SELECT * FROM hero WHERE id = ?", rowMapper, id);
    }
}
