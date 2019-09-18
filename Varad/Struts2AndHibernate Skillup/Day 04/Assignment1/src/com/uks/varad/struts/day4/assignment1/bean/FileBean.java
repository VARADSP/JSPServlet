package com.uks.varad.struts.day4.assignment1.bean;


/**
 * @author: 	Varad Paralikar
 * Created Date:02/09/2019
 * Assignment:  Day 4
 * Task: 		Struts And Hibernate Skillup
 *
 */

/*
 * Class LoginBean is used as bean class
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class FileBean {
	//file bean attributes
	private String fileName;
	private String filePath;


	/*
	 * method getFileName returns file name
	 * return type : String
	 */
	public String getFileName() {
		return fileName;
	}

	/*
	 * method setFileName sets file Name
	 * return type : void
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/*
	 * method getFilePath returns file path
	 * return type : String
	 */
	public String getFilePath() {
		return filePath;
	}


	/*
	 * method setFilePath sets file path
	 * return type : void
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
