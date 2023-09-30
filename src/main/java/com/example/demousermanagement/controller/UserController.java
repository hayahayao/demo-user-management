package com.example.demousermanagement.controller;

import com.example.demousermanagement.bean.User;
import com.example.demousermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public ModelAndView selectLike(String search) {
        ModelAndView modelAndView = new ModelAndView("index::userTable");
        modelAndView.addObject("user_list", userService.selectLike(search));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(Integer id) {
        userService.deleteUser(id);
        ModelAndView modelAndView = new ModelAndView("index::userTable");
        modelAndView.addObject("user_list", userService.selectAllUser());
        return modelAndView;
    }

    @PostMapping("/insert")
    public ModelAndView insertUser(User user) {
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView("index::userTable");
        modelAndView.addObject("user_list", userService.selectAllUser());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView updateUser(User user) {
        userService.updateUser(user);
        ModelAndView modelAndView = new ModelAndView("index::userTable");
        modelAndView.addObject("user_list", userService.selectAllUser());
        return modelAndView;
    }
}
