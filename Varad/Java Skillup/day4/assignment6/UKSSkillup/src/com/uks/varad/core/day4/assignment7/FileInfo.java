package com.uks.varad.core.day4.assignment7;
import java.io.File;

public class FileInfo {
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
		new FileInfo().printDetails(args[0]);
	}
}