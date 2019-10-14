package assignment1;
/* 
 * Class TestReadExcelSheet which is used to test ReadExcelSheet data using external apache poi library  
 * @author: Varad Parlikar
 *  Created Date: 2019/07/03
 */
public class TestReadExcelSheet {
	public static void main(String[] args) {//main method
		try{
			ReadExcelSheet excelSheet = new ReadExcelSheet();
			excelSheet.readExcelSheet();

		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
