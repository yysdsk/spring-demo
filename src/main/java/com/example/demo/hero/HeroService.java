package com.example.demo.hero;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class HeroService {
    private HeroDao heroDao;

    public HeroService(HeroDao heroDao){
        this.heroDao = heroDao;
    }

    public List<Hero> findAll(){
        return heroDao.finAll();
    }
}
