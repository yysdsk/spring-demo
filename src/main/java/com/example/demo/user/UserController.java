package com.example.demo.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public User getUser(@PathVariable String id) {
        return userService.findById(id);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> ERDAExeptionp() {
        return new ResponseEntity<>("IDがありませんよ",
                HttpStatus.valueOf(404));
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
