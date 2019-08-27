package com.uks.kailas.ass4;

/**
*
Assignment :4
Assignment :get data from jsp and print on console
Author : Kailas
Date   : 16/8/2019
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBConnection;

@WebServlet(Constants.PATTERNASS4)
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
		String intrest=null;
		PreparedStatement preparedstmt = null;
		ResultSet rs = null;
		// For Japanese letter unicode
		PrintWriter out = response.getWriter();
		response.setContentType(Constants.CTYPPE);
		request.setCharacterEncoding(Constants.UTF);
		response.setCharacterEncoding(Constants.UTF);
		  out.println(Constants.CENETR);

			// getting the user input data from jsp pages using PrintWriter

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

				// Printing all user inputs data on Browser
				out.print(Constants.BROWSER);
				   out.println(Constants.TABLE);
				   out.println(Constants.UNAMETR + uname + Constants.TD);
				   out.println(Constants.PASSTR + pass +Constants.TD);
				   out.println(Constants.SALTR + sal +Constants.TD);
				   out.println(Constants.FNAMETR + fname + Constants.TD);
				   out.println(Constants.MNAMETR + mname +Constants.TD);
				   out.println(Constants.LNAMETR + lname +Constants.TD);
				   out.println(Constants.SEXTR + sex + Constants.TD);
				   out.println(Constants.EMAILTR + email + Constants.TD);
				   out.println(Constants.BIRTHTR + dob + Constants.TD);
				   out.println(Constants.ADDRESSTR + address +Constants.TD);


					// Printing all the Interest one by one
					if (interest != null) {

						for (String inter : interest) {
							intrest= inter+",";
							 out.println(Constants.INTTR + intrest +Constants.TD);
						}

					}

					 out.println(Constants.OTHERTR + othInterest + Constants.TD);
				   out.println(Constants.CTABLE);
		            out.println(Constants.CHTML);

		    		try {

						connection = DBConnection.initializeDatabase();
						  String query = Constants.QUERY_ASS_FOUR;

						  preparedstmt = connection.prepareStatement(query);
						  preparedstmt.setString(1, uname);
						    rs = preparedstmt.executeQuery();

						    if(rs.next()) {

						    	 out.println(Constants.ERRORFORASS4);

						    }
						    else{
						    	// Query fire for insertion operation with column name and values
						    	PreparedStatement prepStmt = connection.prepareStatement(Constants.QUERY_ASSTWO);	// Set all variable values in prepared statment
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
						// TODO Auto-generated catch block
						 out.println(Constants.ERRORFORDBASS4);

						   System.out.println(e);
					}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(Constants.UTF);

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
