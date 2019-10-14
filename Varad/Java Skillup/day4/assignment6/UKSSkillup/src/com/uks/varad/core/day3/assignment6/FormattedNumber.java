package com.uks.varad.core.day3.assignment6;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.text.DecimalFormat;
public class FormattedNumber {
    /**
     * Class FormattedNumber which contains methods to numbers in formatted output as provided in the input
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public void printFormattedNumber(String format, Double number) {
        /**
         * method printFormattedNumber prints numbers in given format
         * @String
         * @Double return type : void
         */
        DecimalFormat ft = new DecimalFormat(format);
        System.out .println("Number in given format: num = " + ft.format(number));
    }
    public static void main(String[] args) {
        FormattedNumber formattedNumber = new FormattedNumber();
        formattedNumber.printFormattedNumber("###", (double) 123.4567);
    }
}