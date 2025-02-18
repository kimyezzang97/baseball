package com.baseball.dto.admin;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameForm {
    private String gameDate;
    private List<String> winPlayerName;
    private List<Double> winPlayerHitPercent;
    private List<Integer> winPlayerHit;
    private List<Integer> winPlayerHomerun;
    private List<Boolean> winPlayerMVP;
    private List<Integer> winPlayerMoney;

    private List<String> losePlayerName;
    private List<Double> losePlayerHitPercent;
    private List<Integer> losePlayerHit;
    private List<Integer> losePlayerHomerun;
    private List<Boolean> losePlayerMVP;
    private List<Integer> losePlayerMoney;
}
