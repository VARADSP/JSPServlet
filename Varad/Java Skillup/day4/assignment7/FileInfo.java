package day4.assignment7;
/*
 * @author Varad Parlikar Day4 Assignment7
 */
import java.io.File;

public class FileInfo {
	 /**
     * Class FileInfo which contains methods to print file details such size,isDir,isFile,name,etc.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */

	/**
     * method printDetails prints file details such as file name,size,directory structure
     * @String file path
     * return type : void
     */
	public void printDetails(String filePath){
		File file = new File(filePath);
		if(!file.isDirectory()){
			System.out.println("isFile : "+file.isFile() + "\nisDirectory :" + file.isDirectory() + "\nFile Name :"+file.getName()
			+ "\nFile Size :"+getSize(file) + "\n File Directory :"+file.getParentFile()+" Bytes");
		}else{
			System.out.println("isFile : "+file.isFile() + "\nisDirectory :" + file.isDirectory() + "\nDirectory Name :"+file.getName()
			+ "\nDirectory Size :"+getSize(file) +" Bytes");
		}
	}
	/**
     * method getSize returns total space occupied by file or directory
     * @String file path
     * return type : void
     */
	public static long getSize(File file) {
	    long size;
	    if (file.isDirectory()) {
	        size = 0;
	        for (File child : file.listFiles()) {
	            size += getSize(child);
	        }
	    } else {
	        size = file.length();
	    }
	    return size;
	}
	public static void main(String[] args) {
		try{
			new FileInfo().printDetails(args[0]);
		}
		catch(Exception e){
			System.out.println("Please enter value from command line");
		}
	}
}