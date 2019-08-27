package com.uks.kailas.ass1;

/**
*
Assignment :1
Assignment :get data from jsp and print on console
Author : Kailas
Date   : 16/8/2019
*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.uks.kailas.common.Constants;
@WebServlet(Constants.PATTERNASS1)
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String intrest = "";
				// Storing multiple interest in array
				String[] interest = request.getParameterValues(Constants.INTEREST);
				String year = request.getParameter(Constants.YEAR);
				String month = request.getParameter(Constants.MONTH);
				String day = request.getParameter(Constants.DATE);

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
				out.print(Constants.CONSOLE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{

		doGet(request, response);
		}catch(Exception e){

			System.out.println(e);
		}
	}

}
