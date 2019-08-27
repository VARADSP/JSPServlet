package com.uks.varad.servlet.assignment9;
/*
 * Files class is used to manage files of server directory , this acts as POJO Class
 * @author: Varad Paralikar
 * @Created Date : 2019/08/22
 */
public class Files {
	private String fileNo;
	private String fileName;
	private String fileUrl;
	private String fileSize;
	public Files(String fileNo,String fileName, String fileUrl, String fileSize) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.fileSize = fileSize;
		this.fileNo = fileNo;
	}
	@Override
	public String toString() {
		return "Files [fileName=" + fileName + ", fileUrl=" + fileUrl + ", fileSize=" + fileSize + "]";
	}
	public String getFileName() {
		return fileName;
	}
	public String getFileNo() {
		return fileNo;
	}
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
}
