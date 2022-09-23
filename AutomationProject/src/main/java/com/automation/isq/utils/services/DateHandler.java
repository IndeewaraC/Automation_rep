package com.automation.isq.utils.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 */
public class DateHandler {
/*    public static void main(String... args) throws Exception{
//        System.out.println(Test.getLastDayOfCurrentMonth());
//        System.out.println(getCurrentYear());
        System.out.println(getFirstDate());
        System.out.println(getLastDate());
    }*/

    public static String getFirstDate(){
        String date = "1-" + getCurrentMonthName() + "-" + getCurrentYear();
        return date;
    }

    public static String getLastDate(){
        String date = getLastDayOfCurrentMonth() + "-" + getCurrentMonthName() + "-" + getCurrentYear();
        return date;
    }


    /*
     * Helper methods
     */
    public static String getCurrentMonthName(){
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("MMM").format(cal.getTime());
    }

    public static String getCurrentYear(){
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("yyyy").format(cal.getTime());
    }

    public static int getCurrentMonthNumber(){
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getLastDayOfCurrentMonth(){
        Date today = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);

        Date lastDayOfMonth = calendar.getTime();

        DateFormat sdf = new SimpleDateFormat("dd");
        return Integer.parseInt(sdf.format(lastDayOfMonth));
    }
}