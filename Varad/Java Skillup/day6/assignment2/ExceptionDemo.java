package day6.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/* Class ExceptionDemo generates different exceptions
 * @author: Varad Parlikar
 * Created Date: 2019/06/25
 * */
public class ExceptionDemo {

	/*
	 * method generateIOException generates IO exception
	 * return type : void
	 */

	public void generateIOException() {
		try {
			File file = new File("emp213132.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("IO Exception Thrown");
			e.printStackTrace();
		}
	}
	/*
	 * method generateFileNotFoundException generates exception
	 * return type:void
	 *
	 *
	 */

	public void generateFileNotFoundException() {
		try {
			File file = new File("emp213132.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException Thrown");
			e.printStackTrace();
		}
	}
	/*
	 * method generateException generates the exception
	 * return type : void
	 */

	public void generateException() {
		try {
			int a = 1 / 0;
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("Exception thrown");
			e.printStackTrace();
		}
	}
}
