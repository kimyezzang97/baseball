package com.baseball.dao;

import com.baseball.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    public UserDto getUserById(String id);

    public List<String> getNameList();

    public void memberAdd(String name);
}
