package com.uks.varad.core.day2.assignment1;
import java.util.Scanner;
/**
 * @author Varad Parlikar Day2 Assignment1
 *
 */
public class PopulateArray { //
    /**
     * PopulateArray class for creating object of ArrayPopulation class
     * @author: Varad Parlikar
     * Created Date: 2019/06/19
     */
    public static void main(String[] args) {//main method
        Scanner sc = new Scanner(System.in);
        int size;
        System.out.println("Enter the number of size of array1");
        size = sc.nextInt();
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        int[] resultArray = new int[size * 2];
        ArrayPopulation arrayPopulation = new ArrayPopulation();
        resultArray = arrayPopulation.populateArray(array1, array2, size);
        arrayPopulation.print(resultArray);
        sc.close();
    }
}
