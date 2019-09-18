package com.uks.varad.core.day3.assignment8;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.util.Scanner;
public class TestClassDetail {
    /**
     * Class TestClassDetail which is used to create object of ClassDetail and
     * invoke its methods
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public static void main(String[] args) {// main method
        String nameOfClass = args[0].toString();
        String typeOfInfo = args[1].toString();
        ClassDetail classDetail = new ClassDetail();
        classDetail.printDetails("java.util.Date", "ALL");
    }
}