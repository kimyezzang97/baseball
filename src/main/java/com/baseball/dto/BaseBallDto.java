package com.baseball.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseBallDto {
    private String member_num;
    private String member_name;
    private int member_money;


    private String home_run;
    private String double_out;
    private String mvp_cnt;

    private int try_cnt;
    private int hit_cnt;

    private int win_cnt;
    private int lose_cnt;

    private float average;
}
