package com.uks.varad.struts.day1.assignment1.action;

/**
 * @author: 	Varad Paralikar
 * Created Date:27/08/2019
 * Assignment:  Day 1
 * Task: 		Struts And Hibernate Skillup
 *
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.uks.varad.struts.day1.assignment1.bean.WelcomeBean;
import com.uks.varad.struts.day1.assignment1.logic.WelcomeLogic;

/*
 * Class WelcomeAction is used to implement action for struts
 * @author: Varad Parlikar
 * Created Date: 2019/08/27
 */
@SuppressWarnings("serial")
public class WelcomeAction extends ActionSupport implements ModelDriven<WelcomeBean>{

	private String name;

	private WelcomeBean welcomeBean = new WelcomeBean();

	private WelcomeLogic welcomeLogic = new WelcomeLogic();

	/*
	 * method execute overriden method for action class
	 * return type: String
	 */
	@Override
	public String execute()
	{
		return SUCCESS;
	}

	/*
	 * method getName returns name from logic class
	 * return type : String
	 */
	public String getName() {
		this.name =  welcomeLogic.getName();
		return name;
	}


	/*
	 * method setName sets name
	 * @String
	 * return type : void
	 */
	public void setName(String name) {
		welcomeLogic.setName(name);
	}

	@Override
	public WelcomeBean getModel() {

		return welcomeBean;
	}

	public WelcomeBean getWelcomeBean() {
		return welcomeBean;
	}

	public void setWelcomeBean(WelcomeBean welcomeBean) {
		this.welcomeBean = welcomeBean;
	}
}
