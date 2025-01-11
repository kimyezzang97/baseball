package com.baseball.dao;

import com.baseball.dto.BaseBallDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BaseBallDao {
    public List<BaseBallDto> findAll();

    public List<BaseBallDto> findAll2025_1();

    public int totalMoney();

    public int totalMoney_2025_1();

    public int allTotalMoney();
}
