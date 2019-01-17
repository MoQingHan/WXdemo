package com.testspringboot.lottery.pojo;

public class WechatVO {
    private String errMsg;
    private WXUserInfo userInfo;
    private String signature;//微信签名
    private String iv;//偏移量
    private String encryptedData;//加密字符串
    private String session_key;//微信服务器session
    private String openid;//微信用户id，不同小程序是不同
    private String unionid;//微信用户id，不同小程序是同一个

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public WXUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WXUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Override
    public String toString() {
        return "WechatVO{" +
                "errMsg='" + errMsg + '\'' +
                ", userInfo=" + userInfo +
                ", signature='" + signature + '\'' +
                ", iv='" + iv + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", session_key='" + session_key + '\'' +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                '}';
    }
}
