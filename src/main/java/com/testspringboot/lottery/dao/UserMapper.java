package com.testspringboot.lottery.dao;

import com.testspringboot.lottery.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    List<User> selectAllWxUser();

    User selectByOpenid(String openid);

    User pcLogin(@Param("userName") String userName, @Param("userPwd") String userPwd);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int addMoney(@Param("userId")Long user_id, @Param("money")Integer money,  @Param("modTime")Date modTime);

}