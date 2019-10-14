package com.uks.varad.core.day2.assignment2;
/**
 * @author Varad Parlikar Day2 Assignment2
 */
public class VowelConsonant {//
    /**
     * Class VowelConsonant for checking vowel and consonant
     * @author: Varad Parlikar
     * Created Date: 2019/06/19
     */
    public void checkChar(char character) {//
        /**
         * method checkChar to check vowel and consonant
         * @character
         * return type : void
         */
        switch (Character.toLowerCase(character)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
            System.out.println(character + " is vowel");
            break;
        default:
            System.out.println(character + " is consonant");
        }
    }
}