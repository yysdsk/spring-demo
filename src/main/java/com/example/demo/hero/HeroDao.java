package com.example.demo.hero;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDao {
    private JdbcTemplate jdbc;

    public HeroDao(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Hero> finAll(){
        return jdbc.query("SELECT * FROM hero", new BeanPropertyRowMapper<>(Hero.class));
    }
}
