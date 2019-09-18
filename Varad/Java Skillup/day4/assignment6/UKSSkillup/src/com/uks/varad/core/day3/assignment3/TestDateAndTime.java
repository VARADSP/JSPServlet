package com.uks.varad.core.day3.assignment3;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.util.Scanner;
public class TestDateAndTime {
    /**
     * Class TestStringTokenizer which is used to create object of
     * TestDateAndTime and call its methods
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public static void main(String[] args) throws Exception {// main method
        DateAndTime dateAndTime = new DateAndTime();
        Scanner sc = new Scanner(System.in);
        System.out.println("Want To Provide Date Y|N");
        String answer = sc.next();
        if (answer.equals("Y")) {
            System.out.println("Enter Date");
            String date = sc.next();
            System.out.println("Enter Format");
            String format = sc.next();
            dateAndTime.showDate(format, date);
        } else {
            System.out.println("Enter Format");
            String format = sc.next();
            dateAndTime.showDate(format);
        }   sc.close();
    }
}