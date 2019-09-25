package com.example.demo.hero;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    //単件検索
    @GetMapping("/heroes/{id}")
    public Hero gethero(@PathVariable String id){
        return heroService.findById(id);
    }

}
