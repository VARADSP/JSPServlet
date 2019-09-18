package day5.assignment1;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;

/* Class TestRowPrinter used to test the RowReader class and implement its methods
 * @author: Varad Parlikar
 * Created Date: 2019/06/25
  */

public class TestRowPrinter {
	public static void main(String[] args) throws FileNotFoundException {
		try{
		new RowPrinter().printRows(args[0]);
	}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}