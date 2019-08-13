package com.example.demo.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private String id;

    private String name;

    private String dept;

    private LocalDateTime createdAt;
}
