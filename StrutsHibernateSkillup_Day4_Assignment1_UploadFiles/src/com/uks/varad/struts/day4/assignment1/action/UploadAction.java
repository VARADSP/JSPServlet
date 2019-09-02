package com.uks.varad.struts.day4.assignment1.action;


/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.commons.utils.CommonLogic;
import com.uks.varad.struts.day4.assignment1.bean.FileBean;

import java.io.File;
import java.util.Map;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport implements ModelDriven<FileBean>,SessionAware{

	private FileBean fileBean = new FileBean();
	private Map<String, Object> session;
	private File file;
	private String fileName;
	private String fileContentType;






	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		if(session.get("fileName") == null){

			//using session
			session.put("fileName", fileBean.getFileName());
		}
		return "choose-success";
	}



	public FileBean getFileBean() {
		return fileBean;
	}



	public void setFileBean(FileBean fileBean) {
		this.fileBean = fileBean;
	}



	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
		this.fileBean.setFilePath(this.file.getAbsolutePath());
	}



	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.fileBean.setFileName(fileName);
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}



	/*
	 * method validate validates the application form fields
	 * return type : void
	 */
	// simple validation
	public void validate() {




	}



	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;
	}



	@Override
	public FileBean getModel() {
		// TODO Auto-generated method stub
		return fileBean;
	}

}
