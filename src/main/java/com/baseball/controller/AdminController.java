package com.baseball.controller;

import com.baseball.dao.BaseBallDao;
import com.baseball.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @RequestMapping("/game")
    public ModelAndView game(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/game");
        return modelAndView;
    }
}
