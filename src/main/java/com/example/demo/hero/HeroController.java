package com.example.demo.hero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController {

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    //全件検索
    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        return heroService.findAll();
    }

}
