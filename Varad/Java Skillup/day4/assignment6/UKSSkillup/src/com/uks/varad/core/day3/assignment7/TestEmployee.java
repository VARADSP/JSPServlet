package com.uks.varad.core.day3.assignment7;
public class TestEmployee {
    /**
     * Class TestEmployee which is used to create object of Employee class and invoke its methods
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public static void main(String[] args) {// main method
        if (!args[0].isEmpty()) {
            if (!args[1].isEmpty()) {
                Employee.SalaryStructure employee = new Employee().new SalaryStructure();
                employee.printInfo(args[0], args[1]);
            } else {
                Employee employee = new Employee();
                employee.printInfo(args[0]);
            }
        } else {
            System.out.println("No input is provided");
        }
    }
}
