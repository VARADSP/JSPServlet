package com.uks.varad.struts.day2.assignment2.logic;
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