package com.testspringboot.lottery.dao;

import com.testspringboot.lottery.pojo.Bet;
import org.springframework.stereotype.Repository;

@Repository
public interface BetMapper {
    int deleteByPrimaryKey(Long betId);

    int insert(Bet record);

    int insertSelective(Bet record);

    Bet selectByPrimaryKey(Long betId);

    int updateByPrimaryKeySelective(Bet record);

    int updateByPrimaryKey(Bet record);
}