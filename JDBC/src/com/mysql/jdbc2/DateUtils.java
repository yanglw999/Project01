package com.mysql.jdbc2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date strToUtilDate(String date){
        Date utilDate = null;
        try {
            utilDate = sf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilDate;
    }
    public static java.sql.Date utilDateToSql(Date date){
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    public static String utilDateToString(java.util.Date date){
        String str = sf.format(date);
        return str;
    }
}
