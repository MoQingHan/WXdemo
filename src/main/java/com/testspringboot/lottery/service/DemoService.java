package com.testspringboot.lottery.service;

import com.testspringboot.lottery.common.SnowflakeIdWorker;
import com.testspringboot.lottery.dao.UserMapper;
import com.testspringboot.lottery.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DemoService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据openid 查询用户
     * @param openid
     * @return
     */
    public User getUserByOpenid(String openid){
         return userMapper.selectByOpenid(openid);
    }

    public void insertUser(User u){
        u.setUserId(SnowflakeIdWorker.getID());
        u.setCreateTime(new Date());
         userMapper.insertSelective(u);
        //DateUtils
        //u.setCreateTime();
    }
}
