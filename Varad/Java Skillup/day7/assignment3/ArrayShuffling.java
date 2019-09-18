package day7.assignment3;

import java.util.Random;

/* Class ArrayShuffling contains methods to shuffle the array and print array elements randomly
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class ArrayShuffling {
	/* method printRandomly prints the words from the array randomly
	 * @String[] array of words to shuffle
	 * return type : void
	 */
	static void printRandomly(String[] array) {
		String[] tempArray = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
		Random randomIndex = new Random();
		for (int i = 0; i < array.length; i++) {
			int randomPosition = randomIndex.nextInt(array.length);
			String temp = tempArray[i];
			tempArray[i] = tempArray[randomPosition];
			tempArray[randomPosition] = temp;
		}
		for (String string : tempArray) {
			System.out.println(string);
		}
	}

	public static void main(String[] args) {
		String[] inputArray = new String[] { "String 1", "String 2", "String 3", "String 4", "String 5", "String 6",
				"String 7", "String 8", "String 9", "String 10", "String 11", "String 12", "String 13", "String 14",
				"String 15", "String 16", "String 17", "String 18", "String 19", "String 20" };
		printRandomly(inputArray);
	}
}