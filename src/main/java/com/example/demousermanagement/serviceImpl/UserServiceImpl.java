package com.example.demousermanagement.serviceImpl;

import com.example.demousermanagement.bean.User;
import com.example.demousermanagement.repository.UserRepository;
import com.example.demousermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Override
    public void updateUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> selectLike(String search) {
        List<User> list1 = userRepository.findByUsernameLike("%"+search+"%");
        List<User> list2 = userRepository.findByNicknameLike("%"+search+"%");

        return Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
