package day5.assignment5;
/* @author Varad Parlikar Day5 Assignment1*/

import java.util.Scanner;

/* Class TestDirectoryListing is used to test DirectoryListing class and implement its methods
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class TestDirectoryListing {
	public static void main(String[] args) {
			try{
			Scanner sc = new Scanner(System.in);
			String path,ext;
			int recursive;
			System.out.println("Enter Path");
			path = sc.nextLine();
			System.out.println("Enter allowed extensions separated by comma (* for all)");
			ext = sc.nextLine();
			System.out.println("Allow recursive search? (1/0)");
			recursive = (sc.hasNextInt())?sc.nextInt():1;
			String[] ext1 = (ext.equals("*"))?new String[]{"*"}:ext.split(",");
			new DirectoryListing(ext1).searchFilesWithExtensions(path, ext1, recursive);
			sc.close();
	}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
	}
}