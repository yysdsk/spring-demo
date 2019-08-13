package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Optional<Integer> value = Optional.ofNullable(2);

        String result = value
                .map(it -> {
                    // do something
                    System.out.println(it);

                    return it * 2;
                })
                .map(it -> it * 10)
                .map(it -> "Result: " + it)
                .orElse("11");

        System.out.println(result);
    }

}
