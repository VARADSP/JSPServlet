package com.uks.varad.struts.day5_6.assignment.action;

/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
/*
 * Class LocaleAction is used to change locale of the pages
 * @author: Varad Parlikar
 * Created Date: 2019/9/09
 */
public class LocaleAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request = null;

	public String execute(){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}
}
