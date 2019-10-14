package com.uks.varad.core.day3.assignment4;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * @author Varad Parlikar Day3 Assignment4
 */
public class DateDifference {
    /**
     * Class DateDifference which contains methods to calculate difference between dates
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public void showDateDifference(String date1, String date2) throws Exception {
        /**
         * method showDateDifference calculates difference between given two  dates in number of days unit and returns resultant days
         * @String
         * @String return type : void
         */
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date_1 = null,date_2 = null;
        String startDate = date1,endDate = date2; // calculating the difference b/w startDate and endDate
        date_1 = simpleDateFormat.parse(startDate);
        date_2 = simpleDateFormat.parse(endDate);
        long getDiff = date_2.getTime() - date_1.getTime();// using TimeUnit class from java.util.concurrent package
        long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
        System.out.println("Differance between date " + startDate + " and "+ endDate + " is " + getDaysDiff + " days.");
    }
}