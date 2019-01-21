package com.testspringboot.lottery.service;

import com.testspringboot.lottery.Conf.BaseConf;
import com.testspringboot.lottery.common.SnowflakeIdWorker;
import com.testspringboot.lottery.dao.BetMapper;
import com.testspringboot.lottery.dao.RunLotteryMapper;
import com.testspringboot.lottery.pojo.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RunLottery {
    @Autowired
    RunLotteryMapper runLotteryMapper;
    @Autowired
    BetMapper BetMapper;

    @Scheduled(cron="0 0/2 * * * ?")
    public void runLory(){
        Date date=new Date();
        int num=(int)(1+Math.random()*(10));
        runLotteryMapper.updateMoney(num, BaseConf.BET_TIMES+1,new Date());
        runLotteryMapper.updateWin(num,date);
        runLotteryMapper.updateFail(num,date);
        Bet bet=new Bet();
        bet.setBetNum(num);
        bet.setBetId(SnowflakeIdWorker.getID());
        bet.setCreateTime(new Date());
        BetMapper.insertSelective(bet);
    }
}
