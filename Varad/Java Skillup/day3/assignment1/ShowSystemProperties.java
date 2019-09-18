package day3.assignment1;
/*
 * @author Varad Parlikar Day3 Assignment1
 */
/**
 * Class ShowSystemProperties which is used to create object of
 * SystemProperties class and call its methods
 * @author: Varad Parlikar Created Date: 2019/06/20
 */
public class ShowSystemProperties {
    public static void main(String[] args) {// main method
        SystemProperties systemProperties = new SystemProperties();
        systemProperties.display(args[0]);
    }
}