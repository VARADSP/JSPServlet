<!--
 JSP page success.jsp page displays success message
@author:varad paralikar
Created Date: 2019/8/29
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>

 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style1.css" rel="stylesheet">

</head>
<script>
window.onload = function(){

	// Check browser support
	if (typeof(Storage) !== "undefined") {
		  document.getElementById("totalSize").innerHTML = "Total Bytes Read : " + sessionStorage.getItem("fileSize");
	  // Retrieve
	} else {
	  document.getElementById("totalSize").innerHTML = "";
	}
}

function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);

</script>

<body onload="disableBackButton()">

    <div class="container">
      <header class="header clearfix">
        <nav>

        </nav>
        <!-- Uploader heading -->
        <h3 class="text-muted">File Uploader Status</h3>
      </header>

        <main role="main">

        <div class="jumbotron">
         <a type="button" style="float:right;" href="logout" class="btn btn-info">Go Back</a>
        <!-- form to upload file -->
          <h2 class="display-3">Upload Status</h2>



       	<div id="result">



       	<s:if test="#session.fileName != null">
		<b>File Storage : </b><s:property value = "fileStorage"/>

		<b>	File Name :</b> <s:property value="#session.fileName"/><br>





      <img src="FilesStorage/myfiles/<s:property value="#session.fileName"/>" alt="Image Preview"/>
		</s:if>

			</div>
	<span id="totalSize"></span>
               </div>


        <div class="row marketing">
          <div class="col-lg-6">
            <div id="bookmarksResults"></div>


            </div>

        </div>

      </main>
      	<!-- Footer  -->
      <footer class="footer">

        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>


    </div> <!-- /container -->
</body>



</body>
</html>