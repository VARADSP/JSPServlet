package com.uks.varad.struts.day2.assignment2.logic;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class SessionInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		  Map<String,Object> session = invocation.getInvocationContext().getSession();
	      if(session.isEmpty()){
	    	  return invocation.invoke();// session is empty/expired
	      }
	      return invocation.invoke();
	}
}