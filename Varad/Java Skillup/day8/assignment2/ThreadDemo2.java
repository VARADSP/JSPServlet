package day8.assignment2;

/* Class ThreadDemo2 implements Runnable inteface to use multithreading to print numbers from 1 to 5000
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */
public class ThreadDemo2 implements Runnable {

	/* method run invoked on start of thread and prints numbers from 1 to 5000
	 * return type : void
	 */

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 5000; i++) {
				if (i % 75 == 0) {
					Thread.sleep(200);
				}
				System.out.println("Thread " + Thread.currentThread().getName() + ":" + i);
			}
		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
		}
	}
}
