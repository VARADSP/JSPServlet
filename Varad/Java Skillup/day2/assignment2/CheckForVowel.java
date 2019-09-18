package day2.assignment2;
/**
 * @author Varad Parlikar Day2 Assignment2
 */

/**
 * Class CheckForVowel
 * @author: Varad Parlikar
 * Created Date: 2019/06/19
 */
public class CheckForVowel {//

    public static void main(String[] args) {//main method
        VowelConsonant vowelConsonant = new VowelConsonant();
        if(Character.isDigit(args[0].charAt(0))){
        	System.out.println("Its a digit");
        }
        else{
        	vowelConsonant.checkChar(args[0].charAt(0));
        }
    }
}