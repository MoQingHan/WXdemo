package com.testspringboot.lottery.service;

import com.google.gson.Gson;
import com.testspringboot.lottery.Conf.BaseConf;
import com.testspringboot.lottery.common.SnowflakeIdWorker;
import com.testspringboot.lottery.dao.BetinfoMapper;
import com.testspringboot.lottery.dao.UserMapper;
import com.testspringboot.lottery.pojo.Betinfo;
import com.testspringboot.lottery.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BetinfoMapper betinfoMapper;

    public User getUserByOpenid(String openid){
        return userMapper.selectByOpenid(openid);
    }

    public User addUser(String openid){
        User u=new User();
        u.setMoney(10);
        u.setOpenid(openid);
        u.setStatus(0);
        u.setUserId(SnowflakeIdWorker.getID());
        u.setCreateTime(new Date());
        userMapper.insertSelective(u);
        return u;
    }

    public void addUser(String username,String userpwd){
        User u=new User();
        u.setUserName(username);
        u.setUserPwd(userpwd);
        u.setStatus(1);
        u.setUserId(SnowflakeIdWorker.getID());
        u.setCreateTime(new Date());
        userMapper.insertSelective(u);
    }

    public synchronized String bet(User user,Integer betcount,Integer betnum){
        Map<String ,String > m =new HashMap<String ,String >();
        Gson g=new Gson();
        Integer lastmoney=user.getMoney()-betcount*BaseConf.BET_VALUE;
        if(lastmoney<0){
            m.put("errMsg","没有足够的余额");
            m.put("flag","0");
            return g.toJson(m);
        }
        user.setMoney(lastmoney);
        user.setModTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        Betinfo betinfo=new Betinfo();
        betinfo.setBetCount(betcount);
        betinfo.setCreateTime(new Date());
        betinfo.setInfoId(SnowflakeIdWorker.getID());
        betinfo.setStatus(0);
        betinfo.setUserId(user.getUserId());
        betinfo.setBetNum(betnum);
        betinfoMapper.insertSelective(betinfo);
        m.put("errMsg","下注成功");
        m.put("flag","1");
        return g.toJson(m);
    }


    public void updateUserInfo(User user){
        Integer money=user.getMoney();
        user.setMoney(null);
        userMapper.updateByPrimaryKeySelective(user);
        user.setMoney(money);
    }



    public User login(String username,String userpwd){
        Map<String ,String > m =new HashMap<>();
       if(StringUtils.isBlank(username)){
            m.put("flag","0");
            m.put("errMsg","用户名不能为空");
            return null;
       }

        if(StringUtils.isBlank(userpwd)){
            m.put("flag","0");
            m.put("errMsg","密码不能为空");
            return null;
        }

        User u =userMapper.pcLogin(username,userpwd);
        return u;
    }


    public String  addMoney(Long user_id,Integer money){
        Map<String ,String > m =new HashMap<>();
        Gson g=new Gson();
        if(money<0){
            m.put("errMsg","金额有误，请重新充值");
            m.put("flag","0");
            return g.toJson(m);
        }
        userMapper.addMoney(user_id,money,new Date());
        m.put("errMsg","充值成功");
        m.put("flag","1");
        return g.toJson(m);
    }

    public List<User> selectAllWxUser(){
        return userMapper.selectAllWxUser();
    }
}
