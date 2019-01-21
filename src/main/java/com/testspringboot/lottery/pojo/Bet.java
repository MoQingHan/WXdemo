package com.testspringboot.lottery.pojo;

import java.util.Date;

public class Bet {
    private Long betId;

    private Date createTime;

    private Integer betNum;

    private Long user_id;

    private Integer money;

    private String user_name;

    private String user_pwd;

    private Integer betcount;
    private Integer betnum;

    public Integer getBetcount() {
        return betcount;
    }

    public void setBetcount(Integer betcount) {
        this.betcount = betcount;
    }

    public Integer getBetnum() {
        return betnum;
    }

    public void setBetnum(Integer betnum) {
        this.betnum = betnum;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBetNum() {
        return betNum;
    }

    public void setBetNum(Integer betNum) {
        this.betNum = betNum;
    }
}