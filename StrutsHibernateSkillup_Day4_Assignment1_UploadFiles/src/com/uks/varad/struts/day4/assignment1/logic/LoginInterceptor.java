package com.uks.varad.struts.day4.assignment1.logic;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * @author: 	Varad Paralikar
 * Created Date:29/08/2019
 * Assignment:  Day 2
 * Task: 		Struts And Hibernate Skillup
 *
 */
/*
 * Class SessionInterceptor is used to implement session interceptor and session timeout
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		  Map<String,Object> session = invocation.getInvocationContext().getSession();
		  if(session.get("fileName") == null){
			  return "session";
		  }
	      return invocation.invoke();
	}
}