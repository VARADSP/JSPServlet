package day5.assignment2;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;

/* Class TestRowToFileConverter is used to create object of RowToFileConverter and implement its methods
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class TestRowToFileConverter {
	public static void main(String[] args) throws FileNotFoundException {
		try{
		new RowToFileConverter().convertToFile(args[0], args[1]);
	}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}