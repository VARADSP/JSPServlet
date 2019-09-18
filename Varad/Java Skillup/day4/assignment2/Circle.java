package day4.assignment2;
/*
 * @author Varad Parlikar Day4 Assignment2
 */
import java.util.Scanner;

/**
 * Class Circle which contains radius and calculate area of circle method.
 * @author: Varad Parlikar Created Date: 2019/06/21
 */
public class Circle {
	double radius;	final static double PI=3.14159;
	 /**
     * method calculateAreaOfCircle calculates area of circle with double value
     * @double radius in double format
     * return type : void
     */
	public void calculateAreaOfCircle(double radius){ System.out.println("Double");System.out.println("Area Of Circle = "+ PI*radius*radius); }
	 /**
     * method calculateAreaOfCircle calculates area of circle with long value
     * @long radius in long format
     * return type : void
     */
	public void calculateAreaOfCircle(long radius){System.out.println("Long"); System.out.println("Area Of Circle = "+ PI*radius*radius); }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter radius of circle");
		String input = sc.next();
		try{ new Circle().calculateAreaOfCircle(Long.parseLong(input)); }
		catch(NumberFormatException e){
			try{	new Circle().calculateAreaOfCircle(Double.parseDouble(input)); }
			catch(Exception e1){ System.out.println("Invalid number entered! "); e1.printStackTrace(); }
		}
		sc.close();
	}
}