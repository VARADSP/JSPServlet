package com.uks.varad.core.day3.assignment7;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
public class Employee {
    /**
     * Class Employee which contains methods and fields to calculate basic salary,total salary and hra of employee
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    private String employeeName;
    public void printInfo(String empName) {
        /**
         * method printInfo prints employee name
         * return type : void
         */
        employeeName = empName;
        System.out.println("Employee Name =" + employeeName);
    }
    class SalaryStructure {
        /**
         * Class SalaryStructure which contains methods to calculate and print salary structure
         * @author: Varad Parlikar Created Date: 2019/06/20
         */
        private double hra,basicSal;
        public void printInfo(String empName, String salary) {
            /**
             * method printInfo prints employee name,basic salary,hra,total salary
             * return type : void
             */
            basicSal = Integer.parseInt(salary);
            hra = basicSal * (12.5 / 100);
            double totalSal = basicSal + hra;
            employeeName = empName;
            System.out.println("Employer Name =" + employeeName + "\n" + "Employer Basic Salary =" + basicSal + "\n" + "Employer HRA =" + hra + "\n" + "Employer Total Salary ="+ totalSal);
        }
    }
}