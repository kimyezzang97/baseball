package com.baseball.controller;

import com.baseball.dao.BaseBallDao;
import com.baseball.dto.BaseBallDto;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BaseBallController {

    @Autowired
    private BaseBallDao baseBallDao;

    @RequestMapping("/list")
    public ModelAndView hello( Model model){
        ModelAndView modelAndView = new ModelAndView();

        List<BaseBallDto> list = baseBallDao.findAll();
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping("/index")
    public String test( Model model){
        ModelAndView modelAndView = new ModelAndView();

        return "index";
    }
}
