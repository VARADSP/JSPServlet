package day3.assignment7;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import day3.assignment7.Employee.SalaryStructure;
/**
 * Class TestEmployee which is used to create object of Employee class and invoke its methods
 * @author: Varad Parlikar Created Date: 2019/06/20
 */
public class TestEmployee {
    public static void main(String[] args) throws Exception {// main method
        if (!args[0].isEmpty()) {
            if (!args[1].isEmpty()) {
                Employee.SalaryStructure employee = new Employee().new SalaryStructure();
                employee.printInfo(args[0], args[1]);
            } else {
                Employee employee = new Employee();
                employee.printInfo(args[0]);
            }
        } else {
            System.out.println("Please provide input!");
        }
    }
}