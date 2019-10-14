package com.uks.varad.struts.day5_6.assignment.logic;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * @author: 	Varad Paralikar
 * Created Date:09/10/2019
 * Assignment:  Day 5-6
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class SessionInterceptor is used to implement session interceptor and session timeout
 * @author: Varad Parlikar
 * Created Date: 2019/09/9
 */
@SuppressWarnings("serial")
public class SessionInterceptor extends AbstractInterceptor implements
StrutsStatics{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("IN session interceptor");
		  Map<String,Object> session = invocation.getInvocationContext().getSession();
		  final ActionContext context = invocation.getInvocationContext();
		  HttpServletRequest request = (HttpServletRequest) context
					.get(HTTP_REQUEST);
			HttpServletResponse response = (HttpServletResponse) context
					.get(HTTP_RESPONSE);
			// For Japanese letter unicode
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
	     System.out.println("In session interceptor " + invocation.invoke());

	     if(session.isEmpty()){
	    	  System.out.println("session expired");

	    	  return invocation.invoke();// session is empty/expired
	      }


	      return invocation.invoke();
	}
}