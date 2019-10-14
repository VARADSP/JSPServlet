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
import com.uks.varad.struts.commons.utils.Constants;
import com.uks.varad.struts.day4.assignment1.bean.FileBean;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/*
 * Class LogicAction is used as action class for login
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class ShowAction extends ActionSupport implements ModelDriven<FileBean>,SessionAware{
	private FileBean fileBean = new FileBean();
	private Map<String, Object> session;
	private String fileStorage = Constants.fileStorage;

	/*
	 * method getFileStorage returns location of fileStorage
	 * return type : String
	 */
	public String getFileStorage() {
		return fileStorage;
	}

	/*
	 * method setFileStorage sets the location of file storage
	 * @String fileStorage location
	 * return type : void
	 */
	public void setFileStorage(String fileStorage) {
		this.fileStorage = fileStorage;
	}

	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {

		addActionMessage("Successfully Uploaded File !");
		return "success";
	}

	/*
	 * method getFileBean returns file bean
	 * return type : FileBean
	 */
	public FileBean getFileBean() {
		return fileBean;
	}

	/*
	 * method setFileBean sets file bean
	 * @FileBean fileBean to be set
	 * return type : void
	 */
	public void setFileBean(FileBean fileBean) {
		this.fileBean = fileBean;
	}

	/*
	 * method getModel returns logicBean
	 * return type : LogicBean
	 */
	@Override
	public FileBean getModel() {
		return fileBean;
	}


	/*
	 * method getSession method which is implemented method
	 * return type : Map
	 */
	public Map<String, Object> getSession() {
        return session;
   }

	/*
	 * method setSession sets the session attributes
	 * @Map session map
	 * return type : void
	 */
   public void setSession(Map<String, Object> session) {
        this.session = session;
   }

}
