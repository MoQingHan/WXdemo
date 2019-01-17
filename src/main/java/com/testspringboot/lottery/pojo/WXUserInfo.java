package com.testspringboot.lottery.pojo;

public class WXUserInfo {
    private String nickName;//昵称
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;//头像

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "WXUserInfo{" +
                "nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
