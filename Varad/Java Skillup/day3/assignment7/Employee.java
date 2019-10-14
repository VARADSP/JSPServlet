package day3.assignment7;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
/**
 * Class Employee which contains methods and fields to calculate basic salary,total salary and hra of employee
 * @author: Varad Parlikar Created Date: 2019/06/20
 */
public class Employee {
    private String employeeName;
    /**
     * method printInfo prints employee name
     * return type : void
     */
    public void printInfo(String empName) {
        employeeName = empName;
        System.out.println("Employee Name =" + employeeName);
    }
    /**
     * Class SalaryStructure which contains methods to calculate and print salary structure
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    class SalaryStructure {
        private double hra,basicSal;
        /**
         * method printInfo prints employee name,basic salary,hra,total salary
         * return type : void
         */
        public void printInfo(String empName, String salary) {
            basicSal = Integer.parseInt(salary);
            hra = basicSal * (12.5 / 100);
            double totalSal = basicSal + hra;
            employeeName = empName;
            System.out.println("Employer Name =" + employeeName + "\n" + "Employer Basic Salary =" + basicSal + "\n" + "Employer HRA =" + hra + "\n" + "Employer Total Salary ="+ totalSal);
        }
    }
}