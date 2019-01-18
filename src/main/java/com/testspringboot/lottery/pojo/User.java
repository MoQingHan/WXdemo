package com.testspringboot.lottery.pojo;

import java.util.Date;

public class User {
    /**   user_id **/
    private Long userId;

    /**   user_name **/
    private String userName;

    /**   user_mobile **/
    private String userMobile;

    /**   user_pwd **/
    private String userPwd;

    /**   openid **/
    private String openid;

    /**   unionid **/
    private String unionid;

    /**   status **/
    private Integer status;

    /**   create_time **/
    private Date createTime;

    /**   money **/
    private Integer money;

    /**     user_id   **/
    public Long getUserId() {
        return userId;
    }

    /**     user_id   **/
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**     user_name   **/
    public String getUserName() {
        return userName;
    }

    /**     user_name   **/
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**     user_mobile   **/
    public String getUserMobile() {
        return userMobile;
    }

    /**     user_mobile   **/
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**     user_pwd   **/
    public String getUserPwd() {
        return userPwd;
    }

    /**     user_pwd   **/
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**     openid   **/
    public String getOpenid() {
        return openid;
    }

    /**     openid   **/
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**     unionid   **/
    public String getUnionid() {
        return unionid;
    }

    /**     unionid   **/
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**     status   **/
    public Integer getStatus() {
        return status;
    }

    /**     status   **/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**     create_time   **/
    public Date getCreateTime() {
        return createTime;
    }

    /**     create_time   **/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**     money   **/
    public Integer getMoney() {
        return money;
    }

    /**     money   **/
    public void setMoney(Integer money) {
        this.money = money;
    }
}