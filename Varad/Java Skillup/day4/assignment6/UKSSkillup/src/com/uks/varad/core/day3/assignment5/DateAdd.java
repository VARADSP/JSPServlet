package com.uks.varad.core.day3.assignment5;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateAdd {
    /**
     * Class DateAdd which contains methods addDate to add years,months,days to the input date and get resultant date
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public void addDate(String inputDate, String addType, Integer number) throws Exception {
        /**
         * method addDate which is used to calculate and return new date from added year or months or days
         * @String
         * @String
         * @Integer return type : void
         */
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = simpleDateFormat.parse(inputDate);
        switch (addType) {
        case "year":
            addYear(date, number);
            break;
        case "month":
            addMonth(date, number);
            break;
        case "date":
            addDay(date, number);
            break;
        }
    }
    public static void addDay(Date date, int i) {
        /**
         * method addDay adds days to the given input date and prints output date
         * @Date
         * @int return type : void
         */
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, i);
        System.out.println("New Date " + cal.getTime());
    }
    public static void addMonth(Date date, int i) {
        /**
         * method addMonth adds months to the given input date and prints output date
         * @Date
         * @int return type : void
         */
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, i);
        System.out.println("New Date " + cal.getTime());
    }
    public static void addYear(Date date, int i) {
        /**
         * method addYear adds years to the given input date and prints output date
         * @Date
         * @int return type : void
         */
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, i);
        System.out.println("New Date " + cal.getTime());
    }
}