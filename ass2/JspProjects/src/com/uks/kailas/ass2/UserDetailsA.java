package com.uks.kailas.ass2;

/**
*
Assignment :1
Assignment :get data from jsp and print on console
Author : Kailas
Date   : 16/8/2019
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.DBConnection;
import com.uks.kailas.common.Constants;

@WebServlet(Constants.PATTERNASS2)
public class UserDetailsA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsA() {
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
		String intrest="";
		PreparedStatement preparedstmt = null;
		ResultSet rs = null;

		// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String sal = request.getParameter(Constants.SALUTATION);
				String fname = request.getParameter(Constants.FIRSTNAME);

				String mname = request.getParameter(Constants.MIDDLENAME);
				String lname = request.getParameter(Constants.LASTNAME);
				String sex =  request.getParameter(Constants.SEX);
				String email = request.getParameter(Constants.EMAILID);
				String year = request.getParameter(Constants.YEAR);
				String month = request.getParameter(Constants.MONTH);
				String day = request.getParameter(Constants.DATE);
				String address = request.getParameter(Constants.ADDRESS);
				String uname = request.getParameter(Constants.USERNAME);
				String pass = request.getParameter(Constants.PASSWORD);
				// Storing multiple interest in array
				String[] interest = request.getParameterValues(Constants.INTEREST);
				String othInterest = request.getParameter(Constants.OTHERINTEREST);

				String dob=year+":"+month+":"+day;

				// Printing all user inputs data on console
				System.out.println();
				System.out.println(Constants.line);

				// Print the form data
				System.out.println(Constants.USERNAMEP
						+ request.getParameter(Constants.USERNAME));
				System.out.println(Constants.PASSWORDP
						+ request.getParameter(Constants.PASSWORD));

				System.out.println(Constants.SALUTATIONP
						+ request.getParameter(Constants.SALUTATION));
				System.out.println(Constants.FIRSTNAMEP
						+ request.getParameter(Constants.FIRSTNAME));
				System.out.println(Constants.MIDDLENAMEP
						+ request.getParameter(Constants.MIDDLENAME));
				System.out.println(Constants.LASTNAMEP
						+ request.getParameter(Constants.LASTNAME));
				System.out.println(Constants.SEXP
						+ request.getParameter(Constants.SEX));
				System.out.println(Constants.EMAILIDP
						+ request.getParameter(Constants.EMAILID));
				System.out.println(Constants.DATEP+dob);

				System.out.println(Constants.ADDRESSP
						+ request.getParameter(Constants.ADDRESS));
				// Printing all the Interest one by one
				if (interest != null) {

					for (String inter : interest) {
					intrest= intrest+inter+",";

					}
					System.out.print(Constants.INTERESTP+intrest);

					System.out.println("\n");
				}
				System.out.println(Constants.LINESPACE
						+ Constants.OTHERINTERESTP
						+ request.getParameter(Constants.OTHERINTEREST));

				System.out.println(Constants.line);

				try {

					connection = DBConnection.initializeDatabase();
					  String query =Constants.QUERY_ASS_FOUR;

					  preparedstmt = connection.prepareStatement(query);
					  preparedstmt.setString(1, uname);
					    rs = preparedstmt.executeQuery();

					    if(rs.next()) {

					    	 out.println(Constants.ERRORFORASS2);

					    }
					    else{
					    	// Query fire for insertion operation with column name and values
							PreparedStatement prepStmt = connection.prepareStatement(Constants.QUERY_ASSTWO);
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
							prepStmt.setString(11, intrest);
							prepStmt.setString(12, othInterest);

							// executing the query
							int i = prepStmt.executeUpdate();
							if (i > 0) {
								out.println(Constants.REGISTERED);
							}
					    }

				} catch (Exception e) {

					 out.println(Constants.ERRORFORDBASS2);

						   System.out.println(e);
				}

				out.print(Constants.CONSOLE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
