package day7.assignment2;

import java.io.File;

import day7.assignment1.*;

/* Class ExecutionInfo is used to measure memory usage and execution time of the program being invoked
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class ExecutionInfo {

    
	public static void main(String[] args) {//main method
	    String nameToSearch = "John D'Souza";
        String filePath = "D:\\PRTOT\\NEWWSPRTOT\\JavaSkillUp\\src\\day7\\assignment1\\Test2";
        long endTime,startTime,freeMem;
        File f;
		try {
			// get a Runtime object
			Runtime r = Runtime.getRuntime();

			// measuring exection time
			startTime = System.currentTimeMillis();

			// determine the current amount of free memory
			freeMem = r.freeMemory();
			System.out.println("free memory before creating calling objects: " + freeMem);
			System.out.println("free memory before calling garbage collector: " + freeMem);

			
			 f = new File(filePath);
			if (f.isDirectory()) {
				new FindInFiles().readFromDirectory(nameToSearch, filePath);
			} else {
				new FindInFiles().readFromFile(nameToSearch, filePath);
			}

			// determine amount of memory left after consumption
			freeMem = r.freeMemory();
			System.out.println("free memory after creating objects:  " + freeMem);

			// run the garbage collector, then check freeMemory
			r.gc();
			freeMem = r.freeMemory();
			System.out.println("free memory after calling garbage collector:    " + freeMem);

			// end time for execution
			endTime = System.currentTimeMillis();
			System.out.println("Execution Time " + (endTime - startTime) + " milliseconds");
		} catch (Exception e) {
			System.out.println("Invalid input provided" + e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
}
