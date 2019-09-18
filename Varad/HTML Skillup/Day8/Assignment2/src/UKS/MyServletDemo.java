package UKS;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


// Extend HttpServlet class to create Http Servlet
public class MyServletDemo extends HttpServlet {

   private String mymsg;

   public void init() throws ServletException {

   }

   public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException
   {

      // Setting up the content type of webpage
      response.setContentType("text/html");

      // Writing message to the web page
      PrintWriter out = response.getWriter();

try {

	 String name=request.getParameter("name");

    Long mobileno=Long.parseLong(request.getParameter("mn"));
    String role=request.getParameter("role");

	Class.forName("com.mysql.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_varad","varad","varad@654");
	Statement statement=connection.createStatement();
	statement.executeUpdate("insert into employees_test(Name,PhoneNo,Role) values('"+name +"',"+mobileno+",'"+ role+"')");

     String filePath = "D:\\PRTOT\\NEWWSPRTOT\\EmployeesManager\\WebContent\\localstorage\\employees.txt";

     File outputFile = new File(filePath);
     FileWriter fileWriter = new FileWriter(outputFile,true);
     PrintWriter printWriter = new PrintWriter(fileWriter);
     printWriter.println(name+","+mobileno+","+role);

     printWriter.close();


	 out.println("<script type=\"text/javascript\">");
	   out.println("alert('Employee details added successfully !');");
	   out.println("location='index.jsp';");
	   out.println("</script>");


} catch (Exception e) {

	response.sendRedirect("index.jsp");
}






     // out.println("<h1>" + mymsg + "</h1>");



   }

   public void destroy() {
      /* leaving empty for now this can be
       * used when we want to do something at the end
       * of Servlet life cycle
       */
   }
}