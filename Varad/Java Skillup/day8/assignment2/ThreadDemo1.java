package day8.assignment2;

/* Class ThreadDemo1 extends thread class to use multithreading to print numbers from 1 to 5000
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */
public class ThreadDemo1 extends Thread {

	/* method run invoked on start of thread to print numbers from 1 to 5000
	 * return type : void
	 */

	public void run() {
		try {
			for (int i = 1; i <= 5000; i++) {
				if (i % 50 == 0) {
					sleep(100);
				}
				System.out.println("Thread " + getName() + ":" + i);
			}

		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
}
