package com.uks.varad.servlet.assignment1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 	Varad Paralikar
 * Created Date:14/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

/**
 * Class Servlet implementation class UserDetails
 *
 */

/*
 * Class UserDetails used to print the user details on the console window
 * @author: Varad Parlikar
 * Created Date: 2019/08/14
 */
@WebServlet("/assignment1/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String salutation = request.getParameter("sal1");
				String firstName = request.getParameter("firstName");
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String sex = request.getParameter("gender");
				String email = request.getParameter("emailId");
				String dobYear = request.getParameter("year");
				String dobMonth = request.getParameter("month");
				String dobDay = request.getParameter("day");
				String dateOfBirth = dobYear+"/"+dobMonth+"/"+dobDay;
				String address = request.getParameter("address");
				String uname = request.getParameter("uname");
				String pass = request.getParameter("pass");
				// Storing multiple interest in array
				String[] interest = request.getParameterValues("interests");
				String othInterest = request.getParameter("otherInterests");


				// Printing all user inputs data on console
				System.out.println();
				System.out.println("================================================\n");
				System.out.println("Personal Details:\n");
				System.out.println("Salutation is: " + salutation);
				System.out.println("First Name is: " + firstName);
				System.out.println("Middle Initial is: " + middleName);
				System.out.println("Lastname is: " + lastName);
				System.out.println("Sex is: " + sex);
				System.out.println("Email Id is: " + email);
				System.out.println("Birth Date is: " + dateOfBirth);
				System.out.println("Address is: " + address);
				System.out.println("Username is: " + uname);
				System.out.println("Password is: " + pass);
				// Printing all the Interest one by one
				if (interest != null) {
					System.out.println("Interests are: ");
					for (String inter : interest) {
						System.out.println("\t" + inter);
					}
				}
				System.out.println("Other Interest is: " + othInterest);
				System.out.println("\n================================================");

				// Message prints on web pages for user undastanding
				out.print("<h1 align=\"center\"><b>User Details submitted successfully !</b></h1>");
				out.print("<h1 align=\"center\"><b>User Details are printed on the console !</b></h1>");
			  	out.println("<a type=\"button\" class=\"button\" href=\"UserDetails.jsp\" style=\"text-decoration: none;position:relative;left:45%; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Go Back</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
