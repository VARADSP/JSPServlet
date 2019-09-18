package UKS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;





/**
 * Servlet implementation class UploadFiles
 */

public class UploadFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 // Check that we have a file upload request
	 private boolean isMultipart;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFiles() {
        super();
        // TODO Auto-generated constructor stub
    }





	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		isMultipart = ServletFileUpload.isMultipartContent(request);
		  // Setting up the content type of webpage
	      response.setContentType("text/html");

	      // Writing message to the web page
	      PrintWriter out = response.getWriter();




	      if( !isMultipart ) {
	          out.println("<html>");
	          out.println("<head>");
	          out.println("<title>Servlet upload</title>");
	          out.println("</head>");
	          out.println("<body>");
	          out.println("<p>No file uploaded</p>");
	          out.println("</body>");
	          out.println("</html>");
	          return;
	       }





	        File file = null ;
	    	List fileItems=null;
	    	long sizeInBytes=0;
	       int maxFileSize = 5000 * 1024;
	       int maxMemSize = 5000 * 1024;
	       ServletContext context = request.getServletContext();
	       String filePath = "D:\\PRTOT\\NEWWSPRTOT\\FileUploadProgressBar\\WebContent\\files\\";

	       // Verify the content type
	       String contentType = request.getContentType();

	       if ((contentType.indexOf("multipart/form-data") >= 0)) {
	          DiskFileItemFactory factory = new DiskFileItemFactory();
	          // maximum size that will be stored in memory
	          factory.setSizeThreshold(maxMemSize);

	          // Location to save data that is larger than maxMemSize.
	          factory.setRepository(new File("c:\\temp"));

	          // Create a new file upload handler
	          ServletFileUpload upload = new ServletFileUpload(factory);

	          // maximum file size to be uploaded.
	          upload.setSizeMax( maxFileSize );


	          try {
	             // Parse the request to get file items.
	              fileItems = upload.parseRequest(request);





	             // Process the uploaded file items
	             Iterator i = fileItems.iterator();





	             int percent = 0;
	             while ( i.hasNext () ) {

	            	 percent += 10;
	            	 out.println(percent);
	                 FileItem fi = (FileItem)i.next();





	                 if ( !fi.isFormField () ) {
	                    // Get the uploaded file parameters
	                    String fieldName = fi.getFieldName();
	                    String fileName = fi.getName();
	                    boolean isInMemory = fi.isInMemory();
	                     sizeInBytes = fi.getSize();

	                     if(sizeInBytes > maxFileSize){

	                    	 out.println("File size exceeded !");
	                    	 break;
	                     }

	                    // Write the file
	                    if( fileName.lastIndexOf("\\") >= 0 ) {
	                       file = new File( filePath +
	                       fileName.substring( fileName.lastIndexOf("\\"))) ;
	                    } else {
	                       file = new File( filePath +
	                       fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	                    }
	                    fi.write( file ) ;

	                 }


	              }



	          }


	          catch(Exception ex) {
	        	  out.println("<script type=\"text/javascript\">");
	        	   out.println("alert('Error occurred while uploading file !');");
	        	   out.println("location='index.jsp';");
	        	   out.println("</script>");

	          }





	          	response.sendRedirect("UploadFile.jsp");

	       }







	       else {


	       }





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 throw new ServletException("GET method used with " +
		            getClass( ).getName( )+": POST method required.");
	}

}
