package com.testspringboot.lottery.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String FORMAT_YMDHMS="yyyyMMddHHmmss";

    public static final String FORMAT_YMD_CN="yyyy年MM月dd日";

    public static void main(String[] args) throws ParseException {
        Gson gson = new GsonBuilder().setDateFormat(FORMAT_YMD_CN).create();
        System.out.println( gson.toJson(new Date()));
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
    }

    /**
     * 日期转换成字符串
     * @param date 需要转换的日期对象
     * @param dateFormat 需转换的格式
     * @return str 返回对应格式的日期字符串
     */
    public static String DateToStr(Date date,String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String str = format.format(date);
        return str;
    }

    /**
     * 字符串转换成日期
     * @param str 字符串格式的日期
     * @param dateFormat 日期的格式
     * @return date
     */
    public static Date StrToDate(String str,String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
