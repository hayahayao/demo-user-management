package com.example.demousermanagement.controller;

import com.example.demousermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView toIndex() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("user_list", userService.selectAllUser());
        return view;
    }
}
