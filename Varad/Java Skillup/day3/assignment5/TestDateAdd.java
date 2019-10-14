package day3.assignment5;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
/**
 * Class TestDateAdd which is used to create object of DateAdd and invoke its methods
 * @author: Varad Parlikar Created Date: 2019/06/20
 */
public class TestDateAdd {
    public static void main(String[] args) throws Exception {// main method
        DateAdd dateAdd = new DateAdd();
        dateAdd.addDate(args[0], args[1], Integer.parseInt(args[2]));
    }
}