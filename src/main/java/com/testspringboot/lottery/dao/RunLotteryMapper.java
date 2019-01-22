package com.testspringboot.lottery.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface  RunLotteryMapper {
    int updateMoney(@Param("betNum")Integer betNum,@Param("betTimes")Integer betValue,@Param("modTime")Date modTime);

    int updateWin(@Param("betNum")Integer betNum, @Param("modTime")Date modTime);

    int updateFail(@Param("betNum") Integer betNum,@Param("modTime")  Date modTime);

}
