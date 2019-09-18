package com.uks.varad.struts.day2.assignment1.logic;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;
import com.uks.varad.struts.day2.assignment1.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;
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
 * Class LogicLogin is used to implement login logic
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
@SuppressWarnings("serial")
public class LoginLogic extends AbstractInterceptor implements
StrutsStatics{
	private static final Log log = LogFactory.getLog(LoginLogic.class);
	private static final String USER_HANDLE = "loggedInUser";
	/*
	 * method init called upon initialization
	 * return type : void
	 */
	public void init() {
		log.info("Intializing LoginInterceptor");
	}
	/*
	 *	method destroy called upon destroying application
	 * return type : void
	 */
	public void destroy() {
	}
	/*
	 * method intercept is used as interceptor to validate the application
	 * @ActionInvocation
	 * return type : String
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		// Is there a "user" object stored in the user's HttpSession?
		Object user = session.getAttribute(USER_HANDLE);
		if (user == null) {
			// The user has not logged in yet.
			/* The user is attempting to log in. */
			if (invocation.getAction().getClass().equals(LoginAction.class))
			{
				return invocation.invoke();
			}
			return "login";
		} else {
			return invocation.invoke();
		}
	}
}