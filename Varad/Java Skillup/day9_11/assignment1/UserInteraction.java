package day9_11.assignment1;

/* 
 * Class UserInteraction calls Finder , Loader processes and implements Threads to provide multithreading functionality to user and starts the system  
 * @author: Varad Parlikar
 *  Created Date: 2019/07/02
 */
public class UserInteraction extends Thread {

	@Override
	public synchronized void start() {

		super.start();
		System.out.println("Welcome To The User Management System");

	}

	/* 
     * run method which starts thread execution and initiates loader and finder processes. 
     * return type : void
     */
	@Override
	public void run() {
		super.run();

		Loader loaderProcess = new Loader();
		loaderProcess.start();//starting loader process to prepare the data
		
		try {
            loaderProcess.join(); // wait until data is loaded
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	    Finder finderProcess = new Finder();
        finderProcess.start();//starting finder process to provide user required functionalities
	}
	
}
