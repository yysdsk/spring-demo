package com.example.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    //全件検索
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    //単件検索
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        int a;
        if (userService.findById(id)!=null) {
            a = 200;
        } else {
            a = 404;
        }

        return new ResponseEntity<>(userService.findById(id), HttpStatus.valueOf(a));
    }

    @PostMapping("/users")
    public int insertUser(@RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping("/users")
    public int updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public int deleteUser(@PathVariable String id) {
        return userService.deleteById(id);
    }

    @PostMapping("/users/twice")
    public int insertUserTwice(@RequestBody User user) {
        return userService.insertUserTwice(user);
    }

}
