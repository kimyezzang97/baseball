package com.baseball.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {

    private Long user_id; // PK

    private String id; // 회원 ID

    private String name;

    private String role;

    private String password;
}
