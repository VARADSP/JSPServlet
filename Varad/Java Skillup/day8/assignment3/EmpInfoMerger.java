package day8.assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* Class EmpInfoMerger extends thread class to perform synchronized operations using common resource file which is shared
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */
public class EmpInfoMerger extends Thread {

	String nameFile, addressFile, outputFile;
	static String sharedVariable = "sharedResource.txt";
	// private ThreadLocal<String> mode =
	// new ThreadLocal<String>();
	File sharedResource = new File(sharedVariable);
	String mode;

	//constructor parameterized
	public EmpInfoMerger(String nameFile, String addressFile, String mode) throws IOException {
		this.nameFile = nameFile;
		this.addressFile = addressFile;
		// this.mode.set(mode);
		this.mode = mode;
		if (new File(sharedVariable).createNewFile()) {
			System.out.println("Shared Resource File is created");
		} else {
			System.out.println("Shared Resource File is available");
		}
	}

	//constructor parameterized
	public EmpInfoMerger(String nameFile, String addressFile, String outputFile, String mode) throws IOException {
		this.nameFile = nameFile;
		this.addressFile = addressFile;
		this.outputFile = outputFile;
		// this.mode.set(mode);
		this.mode = mode;
		if (new File(sharedVariable).createNewFile()) {
			System.out.println("Shared Resource File is created");
		} else {
			System.out.println("Shared Resource File is available");
		}
	}

	/* method writeToResource uses thread synchronization to access shared resources and write to it
	 * return type : void
	 */
	public synchronized void writeToResource() throws FileNotFoundException, InterruptedException {
		Scanner scannerForNameFile = new Scanner(new File(nameFile));
		Scanner scannerForAddressFile = new Scanner(new File(addressFile));
		PrintWriter pw = new PrintWriter(new File(sharedVariable));
		while (scannerForNameFile.hasNextLine() && scannerForAddressFile.hasNextLine()) {
			String name = scannerForNameFile.nextLine();
			String address = scannerForAddressFile.nextLine();
			pw.println(name + "," + address);
			Thread.sleep(1000);
		}
		scannerForNameFile.close();
		scannerForAddressFile.close();
		pw.close();
	}

	/* method writeToFile uses thread synchronization to write shared resources contents to new file
	 * return type : void
	 */
	public synchronized void writeToFile() throws InterruptedException, IOException {
		Thread.sleep(2000);
		File outputFilePath = new File(outputFile);
		PrintWriter pw = new PrintWriter(new File(outputFile));
		boolean isShown = false;
		while (sharedResource.length() == 0) {
			if (isShown == false) {
				System.out.println("Shared Resource File is empty, Waiting...");
				isShown = true;
			}
		}
		Scanner sc = new Scanner(new File(sharedVariable));
		if (!outputFilePath.exists()) {
			outputFilePath.createNewFile();
		}
		while (sc.hasNextLine()) {
			pw.println(sc.nextLine());
		}
		Thread.sleep(2000);
		sc.close();
		pw.close();
	}

	/* method print uses thread synchronization to read from the file and print in required format
	 * return type : void
	 */
	public synchronized void print() throws FileNotFoundException {
		Scanner readFile = new Scanner(new File(outputFile));
		String[] tokens;
		int count = 1;
		while (readFile.hasNextLine()) {
			tokens = readFile.nextLine().split(",");
			System.out.println(count++ + ")" + tokens[0]);
			System.out.println(tokens[1]);
		}
		readFile.close();
	}

	/* method run of thread class is invoked at the start of the thread execution
	 * return type : void
	 */
	public synchronized void run() {
		try {
			if (mode.equals("READ")) {

				writeToResource();
			} else if (mode.equals("WRITE")) {

				writeToFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}