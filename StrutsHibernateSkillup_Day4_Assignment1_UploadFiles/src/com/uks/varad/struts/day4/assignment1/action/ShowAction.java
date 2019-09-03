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
import com.uks.varad.struts.commons.utils.Constants;
import com.uks.varad.struts.day4.assignment1.bean.FileBean;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

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



	public String getFileStorage() {
		return fileStorage;
	}



	public void setFileStorage(String fileStorage) {
		this.fileStorage = fileStorage;
	}



	/*
	 * method execute implemented method for struts action class
	 * return type : String
	 */
	// all struts logic here
	public String execute() {
		

		return "success";
	}



	public FileBean getFileBean() {
		return fileBean;
	}



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


	public Map<String, Object> getSession() {
        return session;
   }
   public void setSession(Map<String, Object> session) {
        this.session = session;
   }


}
