package com.uks.varad.core.day4.assignment2;
import java.util.Scanner;

public class Circle {
	double radius;	final static double PI=3.14159;

	public void calculateAreaOfCircle(double radius){ System.out.println("Double");System.out.println("Area Of Circle = "+ PI*radius*radius); }
	public void calculateAreaOfCircle(long radius){System.out.println("Long"); System.out.println("Area Of Circle = "+ PI*radius*radius); }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		String input = sc.next();
		try{ new Circle().calculateAreaOfCircle(Long.parseLong(input)); }
		catch(NumberFormatException e){
			try{	new Circle().calculateAreaOfCircle(Double.parseDouble(input)); }
			catch(Exception e1){ System.out.println("Invalid number entered! "); e1.printStackTrace(); }
		}
		sc.close();
	}
}