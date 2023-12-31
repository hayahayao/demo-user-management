package com.example.demousermanagement.repository;

import com.example.demousermanagement.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsernameLike(String name);

    List<User> findByNicknameLike(String name);
}
