package com.testspringboot.lottery.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

public class GsonUtil {
    public static String toJson(Object obj, String dateFormat){
        GsonBuilder gsonBuilder=new GsonBuilder();
        if(StringUtils.isNotBlank(dateFormat)){
            gsonBuilder.setDateFormat(dateFormat);
        }
        Gson gson=gsonBuilder.create();
        return gson.toString();
    }

    public static String toJson(Object obj){
        return toJson(obj,null);
    }
}
