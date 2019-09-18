package day3.assignment6;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.text.DecimalFormat;
public class FormattedNumber {
    /**
     * Class FormattedNumber which contains methods to numbers in formatted output as provided in the input
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    /**
     * method printFormattedNumber prints numbers in given format
     * @String
     * @Double return type : void
     */
    public void printFormattedNumber(String format, Double number) {
        DecimalFormat ft = new DecimalFormat(format);
        System.out .println("Number in given format: num = " + ft.format(number));
    }
    public static void main(String[] args) {
        FormattedNumber formattedNumber = new FormattedNumber();
        formattedNumber.printFormattedNumber(args[0], (double) Double.parseDouble(args[1]));
    }
}