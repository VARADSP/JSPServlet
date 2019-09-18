package day8.assignment2;

/* Class TestThreads is used to implement multithreading concept and uses different threads to perform the required tasks
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */

public class TestThreads {
	public static void main(String[] args) {//main method
		try{
		ThreadDemo1 thread1 = new ThreadDemo1();
		thread1.setName("Extended Thread Class Object");
		Thread thread2 = new Thread(new ThreadDemo2());
		thread2.setName("Implemented Runnable Interface Object");
		thread1.start();
		thread2.start();
		}
		catch(Exception e){
			System.out.println("Invalid input provided");
			e.printStackTrace();
		}
	}
}
