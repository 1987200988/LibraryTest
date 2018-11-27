package com.example.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /** 
     * 时间戳转为时间(年月日，时分秒) 
     * 
     * @param cc_time 时间戳
     * @return
     */  
    public static String getStrTime(int cc_time) {
        String re_StrTime = null;  
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 例如：cc_time=1291778220  
        long lcc_time = Long.valueOf(cc_time);  
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;  
    }
    public static String getStrTime2(int cc_time) {
        String re_StrTime = null;
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }
    public static String getStrTime3(long cc_time) {
        String re_StrTime = null;
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));
        return re_StrTime;
    }
    /** 
     * 时间转换为时间戳 
     * 
     * @param timeStr 时间 例如: 2016-03-09 
     * @param format  时间对应格式  例如: yyyy-MM-dd 
     * @return 
     */  
    public static long getTimeStamp(String timeStr, String format) {  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = null;
        try {  
            date = simpleDateFormat.parse(timeStr);  
            long timeStamp = date.getTime();  
            return timeStamp;  
        } catch (ParseException e) {
            e.printStackTrace();  
        }  
        return 0;  
    }  
  
}  