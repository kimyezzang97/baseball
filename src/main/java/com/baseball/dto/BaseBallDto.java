package com.baseball.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseBallDto {
    private String member_num;
    private String member_name;
    private int member_money;
    private String member_count;

    private String home_run;
    private String double_out;
}
