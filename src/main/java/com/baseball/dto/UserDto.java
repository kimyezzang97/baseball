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

    public UserDto(Long userId, String id, String name, String role, String password) {
        user_id = userId;
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
    }
}
