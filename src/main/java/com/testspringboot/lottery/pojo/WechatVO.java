package com.testspringboot.lottery.pojo;

public class WechatVO {
    private String errMsg;
    private WXUserInfo userInfo;
    private String signature;
    private String iv;
    private String encryptedData;

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

    @Override
    public String toString() {
        return "WechatVO{" +
                "errMsg='" + errMsg + '\'' +
                ", userInfo=" + userInfo +
                ", signature='" + signature + '\'' +
                ", iv='" + iv + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                '}';
    }
}
