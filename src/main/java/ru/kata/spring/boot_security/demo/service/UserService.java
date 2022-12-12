package ru.kata.spring.boot_security.demo.service;



import org.springframework.security.core.userdetails.UserDetailsService;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {


    void addUser(User user);

    List<User> getList();

    User getUser(Integer id);

    void deleteUser(Integer id);

    void editUser(User user);
}