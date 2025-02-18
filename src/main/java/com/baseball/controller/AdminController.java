package com.baseball.controller;

import com.baseball.dao.BaseBallDao;
import com.baseball.dao.UserDao;
import com.baseball.dto.admin.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
        List<String> list = userDao.getNameList();
        modelAndView.addObject("nameList", list);

        modelAndView.setViewName("admin/game");
        return modelAndView;
    }

    @RequestMapping("/game/register")
    public String registerGame(@ModelAttribute GameForm gameForm){
        System.out.println("경기 날짜: " + gameForm.getGameDate());
        System.out.println("승리 팀: " + gameForm.getWinPlayerName());
        for(String str : gameForm.getWinPlayerName()){
            System.out.println(str);
        }

        System.out.println("패배 팀: " + gameForm.getLosePlayerName());
        for(String str : gameForm.getLosePlayerName()){
            System.out.println(str);
        }
        return "redirect:/game/list";
    }

}
