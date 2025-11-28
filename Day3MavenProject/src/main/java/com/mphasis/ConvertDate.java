package com.mphasis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

    public static void main(String[] args) throws ParseException {

        Date today = new Date();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());

        System.out.println("java.util.Date: " + today);
        System.out.println("java.sql.Date: " + sqlDate);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formateDate = sdf.format(today);
        sqlDate = java.sql.Date.valueOf(formateDate);
        System.out.println(sqlDate);
        
        String strDate = "15-08-2025";
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date uDate = sdf.parse(strDate);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        System.out.println(uDate);
        System.out.println(sDate);
        
        java.sql.Date sqlDate1 = java.sql.Date.valueOf("2025-10-24");
        java.util.Date utilDate1 = new java.util.Date(sqlDate1.getTime());
        java.util.Date utilDate2 = sqlDate1;
        
        System.out.println(sqlDate1);
        
        java.sql.Date sqlDate2 = java.sql.Date.valueOf("2025-02-25");
        String str = sqlDate2.toString();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(sdf1.parseObject(str));
        
        
        String myDate = "2023-06-26";
        sqlDate1 = java.sql.Date.valueOf(myDate);
        System.out.println(sqlDate1);
        utilDate1 = new java.util.Date(sqlDate1.getTime());
        System.out.println(utilDate1);
        
    }
}
