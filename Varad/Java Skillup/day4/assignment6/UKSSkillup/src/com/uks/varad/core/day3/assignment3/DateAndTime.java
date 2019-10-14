package com.uks.varad.core.day3.assignment3;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DateAndTime {
    /**
     * Class DateAndTime which contains methods to show date in specified format
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public void showDate(String outputFormatType, String date)throws Exception {
        /**
         * method showDate used to show date in format type
         * @String
         * @String return type : void
         */
        SimpleDateFormat dateFormat = new SimpleDateFormat(outputFormatType);
        System.out.println(dateFormat.format(dateFormat.parse(date)));
    }
    public void showDate(String outputFormatType) throws Exception {
        /**
         * method showDate prints today's date in given format
         * @String return type : void
         */
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(outputFormatType);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}