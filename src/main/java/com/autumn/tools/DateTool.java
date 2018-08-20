package com.autumn.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Autumn on 2018/7/13.
 */
public class DateTool {
    public static String getDateFormat(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }

    public static String getToday(){
        Calendar calendar = Calendar.getInstance();
        return getDateFormat(calendar.getTime(),"yyyy-MM-dd");
    }
    public static String getNowTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        return time;
    }
    public static void main(String[] args) {
        System.out.println(getToday());
    }
}
