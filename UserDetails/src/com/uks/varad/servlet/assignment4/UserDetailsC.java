package com.uks.varad.servlet.assignment4;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.varad.servlet.DatabaseConnection;

/**
 * Servlet implementation class SaveUserDetailsIntoDatabase
 */
@WebServlet("/assignment4/UserDetailsC")
public class UserDetailsC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsC() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
    	   // Initialization code...
    	connection = null;
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// For Japanese letter unicode
		request.setCharacterEncoding("utf-8");


		// getting the user input data from jsp pages using PrintWriter
		PrintWriter out = response.getWriter();
		String sal = request.getParameter("sal1");
		String fname = request.getParameter("firstName");
		String mname = request.getParameter("middleName");
		String lname = request.getParameter("lastName");
		String sex = request.getParameter("gender");
		String email = request.getParameter("emailId");
		String dob = request.getParameter("date");
		String address = request.getParameter("address");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");


	//	Reader reader = new InputStreamReader(get.openStream(), "UTF-8");

		// Storing multiple interest in array
		String[] interest = request.getParameterValues("interests");
		// Storing interest in local variable
				String allIneterest = "";
				for (int i = 0; i < interest.length; i++) {
					allIneterest += interest[i] + ",".trim();
				}
		String othInterest = request.getParameter("otherInterests");

		DatabaseConnection databaseConnection = new DatabaseConnection();
		try {
			 connection  = databaseConnection.connect();
		} catch (Exception e) {
			  out.println("<script type=\"text/javascript\">");
       	   out.println("alert('Error occurred while submitting data, Please try again!');");
       	   out.println("location='UserDetailsA.jsp';");
       	   out.println("</script>");
		}


		try {
			// Query fire for insertion operation with column name and values
			PreparedStatement prepStmt = connection.prepareStatement(
					"insert into userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			// Set all variable values in prepared statment
			prepStmt.setString(1, sal);
			prepStmt.setString(2, fname);
			prepStmt.setString(3, mname);
			prepStmt.setString(4, lname);
			prepStmt.setString(5, sex);
			prepStmt.setString(6, email);
			prepStmt.setString(7, dob);
			prepStmt.setString(8, address);
			prepStmt.setString(9, uname);
			prepStmt.setString(10, pass);
			prepStmt.setString(11, allIneterest);
			prepStmt.setString(12, othInterest);

			// executing the query
			int i = prepStmt.executeUpdate();
			if (i > 0) {
				out.println("<h1 align=\"center\"><b>You are successfully registered</b></h1>");
			} else {
				out.println("<h1 align=\"center\" style=\"color:red;\"><b>Can not register the data into the database !</b></h1>");
			  	out.println("<a type=\"button\" class=\"button\" href=\"UserDetailsC.jsp\" style=\"text-decoration: none;position:relative;left:45%; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Go Back</a>");

			}

			// Show Data on Console
			System.out.println();
			System.out.println("================================================");
			System.out.println("Salutation is: " + sal);
			System.out.println("First Name is: " + fname);
			System.out.println("Middle Initial is: " + mname);
			System.out.println("Last Name is: " + lname);
			System.out.println("Sex is: " + sex);
			System.out.println("Email Id is: " + email);
			System.out.println("Birth Date is: " + dob);
			System.out.println("Address is: " + address);
			System.out.println("Username is: " + uname);
			System.out.println("Password is: " + pass);
			// printing the interest info on console
			if (interest != null) {
				System.out.println("Interests are: ");
				for (String inter : interest) {
					System.out.println("\t" + inter);
				}
			}
			System.out.println("Other Interest is: " + othInterest);
			System.out.println("================================================");

			// printing the info on the webpage
			out.print("<h1 align=\"center\"><b>Submitted User Details</b></h1>");

			out.println("<html><body align=\"center\">\n" + "<h4>Your Salutation is: " + sal + "</h4>\n" + "<h4>Your First Name is: "
					+ fname + "</h4>\n" + "<h4>Your Middle Name is: " + mname + "</h4>\n" + "<h4>Your Last Name is: " + lname
					+ "</h4>\n" + "<h4>Your Gender is: " + sex + "</h4>\n" + "<h4>Your Email id is: " + email
					+ "</h4>\n" + "<h4>Your Date of Birth is: " + dob + "</h4>\n" + "<h4>Your Address is: " + address
					+ "</h4>\n" + "<h4>Your Username is: " + uname + "</h4>\n" + "<h4>Your Password is: " + pass
					+ "</h4>\n" + "<h4>Your Interests are: " + allIneterest + "</h4>\n" + "<h4>Your Other Interests are: "
					+ othInterest + "</h4>\n" + "</body></html>\n");



		  	out.println("<a type=\"button\" class=\"button\" href=\"UserDetailsC.jsp\" style=\"text-decoration: none;position:relative;left:45%; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Go Back</a>");

		} catch (Exception e) {
			out.print("<h1 align=\"center\" style=\"color:red;\"><b>We cant able to process your request!</b></h1>");
			out.print("<h1 align=\"center\" style=\"color:red;\"><b>Check your username is already registered with us!</b></h1>");
			System.out.println(e);
		  	out.println("<a type=\"button\" class=\"button\" href=\"UserDetailsC.jsp\" style=\"text-decoration: none;position:relative;left:45%; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Go Back</a>");

		}
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
