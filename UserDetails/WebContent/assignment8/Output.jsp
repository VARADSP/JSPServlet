<!--
 JSP page Output displays file upload status
@author:varad paralikar
Created Date: 2019/8/21
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Output</title>

 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">

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

</script>

<body>

    <div class="container">
      <header class="header clearfix">
        <nav>

        </nav>
        <!-- Uploader heading -->
        <h3 class="text-muted">File Uploader Status</h3>
      </header>

        <main role="main">

        <div class="jumbotron">
         <a type="button" style="float:right;" href="FileUpload.jsp" class="btn btn-info">Go Back</a>
        <!-- form to upload file -->
          <h2 class="display-3">Upload Status</h2>



       	<div id="result">
				<h3>${requestScope["messageInfo"]}</h3>
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