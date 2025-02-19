package com.baseball.controller;

import com.baseball.dao.BaseBallDao;
import com.baseball.dao.UserDao;
import com.baseball.dto.admin.GameForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BaseBallDao baseBallDao;

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
    @Transactional
    public String registerGame(@ModelAttribute GameForm gameForm){
        // 날짜
        String gameDate = gameForm.getGameDate();
        Map<String, Object> dateMap = new HashMap<String, Object>();
        dateMap.put("date", gameDate);
        baseBallDao.insertRecord(dateMap);

        // mvp
        int mvp = gameForm.getMvpIndex();

        for(int i=0; i<gameForm.getWinPlayerName().size(); i++){
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("detailId", dateMap.get("id"));
            map.put("name", gameForm.getWinPlayerName().get(i));
            map.put("winStatus", true);
            if(gameForm.getWinPlayerHit().get(i) == 0) map.put("try", 0);
            else map.put("try",  (int) Math.round(gameForm.getWinPlayerHit().get(i) / gameForm.getWinPlayerHitPercent().get(i)));
            map.put("hit", gameForm.getWinPlayerHit().get(i));
            map.put("homerun", gameForm.getWinPlayerHomerun().get(i));

            if(mvp == i) map.put("mvp", true);
            else map.put("mvp", false);
            baseBallDao.insertRecordDetail(map);
        }

        for(int i=0; i<gameForm.getLosePlayerName().size(); i++){
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("detailId", dateMap.get("id"));
            map.put("name", gameForm.getLosePlayerName().get(i));
            map.put("winStatus", false);
            if(gameForm.getLosePlayerHit().get(i) == 0) map.put("try", 0);
            else map.put("try",  (int) Math.round(gameForm.getLosePlayerHit().get(i) / gameForm.getLosePlayerHitPercent().get(i)));
            map.put("hit", gameForm.getLosePlayerHit().get(i));
            map.put("homerun", gameForm.getLosePlayerHomerun().get(i));
            map.put("mvp", false);
            baseBallDao.insertRecordDetail(map);
        }

        return "redirect:/admin";
    }

}
