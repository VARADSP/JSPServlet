package day8.assignment3;

/* Class TestEmpInfoMerger uses EmpInfoMerger class and its methods to implement thread conecpt using synchronization to manipulate employee data
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */

public class TestEmpInfoMerger {
	public static void main(String[] args) {//main method
		try {
			EmpInfoMerger empInfoMerger1 = new EmpInfoMerger("NameFile.txt", "AddressFile.txt", "READ");
			EmpInfoMerger empInfoMerger2 = new EmpInfoMerger("NameFile.txt", "AddressFile.txt", "READ");
			EmpInfoMerger empInfoMerger3 = new EmpInfoMerger("NameFile.txt", "AddressFile.txt", "outputFile.txt",
					"WRITE");

			empInfoMerger1.start();
			empInfoMerger2.start();
			empInfoMerger3.start();

			empInfoMerger1.join();
			empInfoMerger2.join();

			empInfoMerger3.print();
		} catch (Exception e) {
			System.out.println("Invalid input entered !");
			e.printStackTrace();
		}
	}
}
