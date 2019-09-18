package day7.assignment1;

import java.io.File;

/* Class TestFindInFiles used to test FindInFiles class and implements its methods
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class TestFindInFiles {
	public static void main(String[] args) {
		try {
			String nameToSearch = "John D'Souza";
			String filePath = "D:\\PRTOT\\NEWWSPRTOT\\JavaSkillUp\\src\\day7\\assignment1\\Test2";
			File f = new File(filePath);
			if (f.isDirectory()) {
				new FindInFiles().readFromDirectory(nameToSearch, filePath);
			} else {
				new FindInFiles().readFromFile(nameToSearch, filePath);
			}
		} catch (Exception e) {
			System.out.println("Invalid input provided" + e.getMessage() + "\n");
			e.printStackTrace();
		}
	}
}