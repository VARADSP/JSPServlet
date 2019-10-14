package assignment1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/* 
 * Class ReadExcelSheet , it is created to read excel sheet data using external apache poi library  
 * @author: Varad Parlikar
 *  Created Date: 2019/07/03
 */
public class ReadExcelSheet {
    /* method readExcelSheet which is used to read excel sheet data and print it using apache poi 
     * library functions and classes such as XSSFWorkbook,XSSFSheet,Row,Cell
     * return type : void
     */
	public void readExcelSheet(){
	    /*
        For poi-4.1.0 
        add these to the classpath: 
        1.dom4j-1.6.jar xmlbeans-3.1.0.jar 
        2.commons-collections4-4.3.jar 
        3.commons-compress-1.18.jar 
	     * 
	     */
		    try { 
		        
		        System.out.println("Enter excel sheet file path to read :");
		        Scanner scanner = new Scanner(System.in);
		        
		        String filepath = scanner.next();
		        //"C:\\Users\\Varad\\eclipse-workspace\\EvaluationTestPaper\\src\\assignment1\\Book2.xlsx"
	            FileInputStream file = new FileInputStream(new File(filepath)); 
	  
	            // Create Workbook instance holding reference to .xlsx file 
	            XSSFWorkbook workbook = new XSSFWorkbook(file); 
	  
	            // Get first/desired sheet from the workbook 
	            XSSFSheet sheet = workbook.getSheetAt(0); 
	  
	            // Iterate through each rows one by one 
	            Iterator<Row> rowIterator = sheet.iterator(); 
	            int rowCounter = 0;
	            while (rowIterator.hasNext()) { 
	                Row row = rowIterator.next(); 
	                // For each row, iterate through all the columns 
	                Iterator<Cell> cellIterator = row.cellIterator(); 
	  
	                while (cellIterator.hasNext()) { 
	                    Cell cell = cellIterator.next(); 
	                    
	                    if(rowCounter%4==0) {
	                        System.out.println();  
	                    }
	                    System.out.print(cell.toString() + " ");   
	                    ++rowCounter;
	                  
	                   
	                } 
	                System.out.println(""); 
	            } 
	            file.close(); 
	            scanner.close();
	            workbook.close();
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
	} 