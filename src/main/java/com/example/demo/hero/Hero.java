package com.example.demo.hero;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Hero {

        private String id;

        private String name;

        private String birthplace;

        private LocalDateTime createdAt;
}
