package day3.assignment2;
/**
 * @author Varad Parlikar Day3 Assignment2
 */
public class TestStringTokenizer {
    /**
     * Class TestStringTokenizer which contains methods to separate tokens
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    public void getStrings(String args) {
        /**
         * method getStrings used to print tokens from given string
         * @String return type : void
         */
        String[] tokens = args.split(",");
        for (String t : tokens) {
            System.out.println(t);
        }
    }
}