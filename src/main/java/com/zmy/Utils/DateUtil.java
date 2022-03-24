package com.zmy.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sam
 * @create 2021-11-24-19:29
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     * 解析日期,模版yyyy-MM-dd hh:mm:ss
     * 浏览器接收到的日期都是以上模版
     *
     * @param dateStr : 字符串类型的日期
     * @return date : 解析过后的java.util.Date类型的日期
     */
    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 格式化日期
     *
     * @param date : 需要进行格式化的日期
     * @return str : 格式化日期后的到的字符串
     */
    public static String format(Date date) {
        return sdf.format(date);
    }

}
