package day2.assignment3;
/**
 * @author Varad Parlikar Day2 Assignment3
 */
import java.util.regex.Pattern;

/**
 * Class StringOperation to reverse array and counting lowercase,uppercase,digits
 * @author: Varad Parlikar
 * Created Date: 2019/06/19
 */
public class StringOperation {

	 /**
     * method checkChar to check vowel and consonant
     * @String[]
     * return type : void
     */
    public void doOperationWithRegEx(String[] args) {
    	 int countOfLowerCaseWords = 0, countOfUpperCaseWords = 0,countOfDigits = 0;
    	  String regexForLowerCaseWords = ".*[a-z].*",regexForUpperCaseWords = ".*[A-Z].*",regexForDigits = ".*\\d.*";

        if (args[0].equals("1")) {
            // displaying input data in reverse order

                char[] input = args[1].toCharArray();//getting character array
                for (int j = input.length - 1; j >= 0; j--) {
                    System.out.print(input[j]);// printing character array in reverse order
                }
                System.out.println();

        } else if (args[0].equals("2")) {
            for (int i = 1; i < args.length; i++) {
                String argument = args[i];
                for (int j = 0; j < argument.length(); j++) {
                    String text = "" + argument.charAt(j);
                    if (Pattern.matches(regexForUpperCaseWords, text)) {//Uppercase match
                        ++countOfUpperCaseWords;
                    }
                    if (Pattern.matches(regexForLowerCaseWords, text)) {//Lowercase match
                        ++countOfLowerCaseWords;
                    }
                    if (Pattern.matches(regexForDigits, text)) {//Digits match
                        ++countOfDigits;
                    }
                }
            }
            System.out.println("Number Of UpperCase = " + countOfUpperCaseWords + " \nNumber Of LowerCase = " + countOfLowerCaseWords + "\nNumber Of Digits =  " + countOfDigits);
        }
    }
}