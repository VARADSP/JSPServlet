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
import javax.servlet.ServletContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.uks.varad.struts.commons.utils.Constants;

/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport implements ModelDriven<FileBean>,SessionAware,ServletContextAware{

	private FileBean fileBean = new FileBean();
	private Map<String, Object> session;
	private File file;
	private String fileName;
	private String fileContentType;
	private String filePath;


	private String fileFileName;
	private String filesPath;
	@SuppressWarnings("unused")
	private ServletContext context;






	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		fileBean.setFilePath(filePath);
		this.filePath = filePath;
	}



	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		if(getFile() == null || getFileFileName() == null || filesPath == null){
			addActionMessage("You are successfully logged out !");
			return "input";
		}



		if(session.get("fileName") == null){
			//using session
			session.put("fileName", getFileFileName());
		}

		try{

			CommonLogic.saveFile(getFile(), getFileFileName(), Constants.fileStorage + File.separator + filesPath);

		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("Error Uploading File ! Please try again");
			return "error";
		}

		return "choose-success";
	}



	public FileBean getFileBean() {
		return fileBean;
	}


	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		fileBean.setFileName(fileFileName);
		this.fileFileName = fileFileName;
	}

	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
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



	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;
	}



	@Override
	public FileBean getModel() {
		// TODO Auto-generated method stub
		return fileBean;
	}



	@Override
	public void setServletContext(ServletContext ctx) {
		this.context=ctx;
	}


}
