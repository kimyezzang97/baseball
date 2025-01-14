package com.baseball.dao;

import com.baseball.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    public UserDto getUserById(String id);
}
