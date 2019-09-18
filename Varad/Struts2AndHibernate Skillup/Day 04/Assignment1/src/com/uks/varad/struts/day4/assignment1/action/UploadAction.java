package com.uks.varad.struts.day4.assignment1.action;


/**
 * @author: 	Varad Paralikar
 * Created Date:02/09/2019
 * Assignment:  Day 4
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
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.uks.varad.struts.commons.utils.Constants;

/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class UploadAction extends ActionSupport implements ModelDriven<FileBean>,SessionAware,ServletContextAware,StrutsStatics{
	//file attributes
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

	/*
	 * method getFilePath returns file path
	 * return type : String
	 */
	public String getFilePath() {
		return filePath;
	}



	/*
	 * method setFilePath sets the file path
	 * @String filePath to be set
	 * return type : void
	 */
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
			return "input";
		}
		if(session.get("fileName") == null){
			//using session
			session.put("fileName", getFileFileName());
		}

		try{
			//saving file inside web inf
			CommonLogic.uploadFile(getFile(), getFileFileName(), Constants.fileStorage + File.separator + filesPath);
			//displaying file
			CommonLogic.uploadFile(getFile(), getFileFileName(), Constants.fileStorageForDisplaying + File.separator + filesPath);

		}catch(Exception e){
			e.printStackTrace();
			addActionMessage("Error Uploading File ! Please try again");
			return "error";
		}

		return "choose-success";
	}

	/*
	 * method getFileBean returns file bean
	 * return type : FileBean
	 */
	public FileBean getFileBean() {
		return fileBean;
	}

	/*
	 * method getFileFileName returns file name
	 * return type : String
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	/*
	 * method setFileFileName sets file name
	 * @String fileFileName sets the file name
	 * return type : void
	 */
	public void setFileFileName(String fileFileName) {
		fileBean.setFileName(fileFileName);
		this.fileFileName = fileFileName;
	}

	/*
	 * method setFilesPath sets the file path
	 * @String filesPath sets file path
	 * return type : void
	 */
	public void setFilesPath(String filesPath) {
		this.filesPath = filesPath;
	}

	/*
	 * method setFileBean sets file bean
	 * @FileBean
	 * return type : void
	 */
	public void setFileBean(FileBean fileBean) {
		this.fileBean = fileBean;
	}

	/*
	 * method getFile returns file
	 * return type : File
	 */
	public File getFile() {
		return file;
	}
	/*
	 * method setFile sets the file
	 * @File file to be set
	 * return type : void
	 */
	public void setFile(File file) {
		this.file = file;
		this.fileBean.setFilePath(this.file.getAbsolutePath());
	}

	/*
	 * method getFileName returns file name
	 * return type : String
	 */
	public String getFileName() {
		return fileName;
	}

	/*
	 * method setFileName sets the filename
	 * @String fileName to be set
	 * return type : void
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.fileBean.setFileName(fileName);
	}

	/*
	 * method getFileContentType sets the content type of file
	 * return type : String
	 */
	public String getFileContentType() {
		return fileContentType;
	}

	/*
	 * method setFileContentType sets the file content type
	 * @String fileContentType to be set
	 * return type : void
	 */
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
