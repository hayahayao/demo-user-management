package com.example.demousermanagement.service;

import com.example.demousermanagement.bean.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(Integer uid);

    void updateUser(User user);

    List<User> selectAllUser();

    List<User> selectLike(String search);
}
