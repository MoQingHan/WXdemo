package com.testspringboot.lottery.dao;

import com.testspringboot.lottery.pojo.Betinfo;
import org.springframework.stereotype.Repository;

@Repository
public interface BetinfoMapper {
    int deleteByPrimaryKey(Long infoId);

    int insert(Betinfo record);

    int insertSelective(Betinfo record);

    Betinfo selectByPrimaryKey(Long infoId);

    int updateByPrimaryKeySelective(Betinfo record);

    int updateByPrimaryKey(Betinfo record);
}