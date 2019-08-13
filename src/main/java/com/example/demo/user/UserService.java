package com.example.demo.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Slf4j
@Transactional
@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        return userDao.findAll();
    }

    public User findById(String id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        return userDao.findUserBeanPropertyById(id);
    }

    public int insert(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        return userDao.insert(user);
    }

    public int update(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        return userDao.update(user);
    }

    public int deleteById(String id) {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        return userDao.deleteById(id);
    }

    public int insertUserTwice(User user) {
        LocalDateTime localDateTime = LocalDateTime.now();
        final String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
//        System.out.println("log, method:" + methodName + ", Date:" + LocalDateTime.now());
        log.info("log, method:{}, Date:{}", methodName, LocalDateTime.now());
        int row = userDao.insert(user);
        User secondUser = new User();
        secondUser.setId(String.valueOf(Integer.valueOf(user.getId()) * 2));
        secondUser.setName(user.getName());
        secondUser.setDept(user.getDept());
        secondUser.setCreatedAt(user.getCreatedAt());
        System.out.println(secondUser.getId());

        if (new Random().nextInt(100) >= 0) {
            throw new RuntimeException();
        }

        return row + userDao.insert(secondUser);
    }
}

