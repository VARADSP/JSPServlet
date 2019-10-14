package assignment2;

import java.util.Scanner;

/* 
 * Class DecimalToBinary contains functions to convert deciamal number upto 3 digit into binary number 
 * @author: Varad Parlikar
 *  Created Date: 2019/07/03
 */
public class DecimalToBinary {
    
    /* method decimalToBinary converts decimal number into binary number using mod operation logic
     * @int which is decimal number upto 3 digit
     * return type : void
     */
    public static void decimalToBinary(int n) {
        // array to store binary number 
        int[] binaryNum = new int[1000]; 

        // counter for binary array 
        int i = 0; 
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 

        System.out.println("Converted Binary Output :");
        // printing binary array in reverse order 
        for (int j = i - 1; j >= 0; j--) 
            System.out.print(binaryNum[j]); 
    }

    public static void main(String[] args) {
        //main method
     
        try {
        System.out.println("Enter decimal number :");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        if(number > 999) {
            System.out.println("Enter only 3 digit decimal number ");
            System.exit(0);
        }
        decimalToBinary(number); 
        scanner.close();
    }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
}
}