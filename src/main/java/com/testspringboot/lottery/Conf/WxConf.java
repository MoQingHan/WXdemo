package com.testspringboot.lottery.Conf;

import java.io.IOException;
import java.util.Properties;

public class WxConf {
    private static  String appid;
    private static String secret;

    static {
        Properties properties = new Properties();
        try {
            properties.load(WxConf.class.getResourceAsStream("/init.properties"));
            appid=properties.getProperty("appid");
            secret=properties.getProperty("secret");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getAppid() {
        return appid;
    }

    public static String getSecret() {
        return secret;
    }
}
