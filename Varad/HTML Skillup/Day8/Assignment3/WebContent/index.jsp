<%--
    Document   : fileUpload
    Created on : Aug 11, 2019, 10:08:34 AM
    Author     : Varad_Paralikar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- JSP page index.jsp used to upload files
@author:varad paralikar
Created Date: 2019/8/12
-->
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=U  TF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<script language="javascript" type="text/javascript">
/*
function validateForm is used to check if user has selected file to upload
return type:void
*/
	function validateForm()
{
           if(document.getElementById('fileData').value.length == 0){
        		alert("Please select a file to upload");
        		event.preventDefault();
           }


}

	/*
	function alertFileSize alerts user if size limit is reached !
	return type:void
	*/
	function alertFileSize(){
		var inpFiles = document.getElementById('fileData');
		for (var i = 0; i < inpFiles.files.length; ++i) {
		    var size = inpFiles.files.item(i).size;

		    if(size > 20971520){
		    	alert('File size exceeded ! Size Limit is 20MB');
		    	location='index.jsp';
		    }
		}
	}
</script>
    </head>

  <body>

    <div class="container">
      <header class="header clearfix">
        <nav>

        </nav>
        <!-- Uploader heading -->
        <h3 class="text-muted">File Uploader</h3>
      </header>

      <main role="main">

        <div class="jumbotron">
        <!-- form to upload file -->
          <h2 class="display-3">Upload Your Files</h2>
          <form id="myForm" action="UploadFiles" ENCTYPE="multipart/form-data" method="post">
            <div class="form-group">
              <label>Select Your File</label>
              <input type="file" name="fileData" class="form-control" onchange="alertFileSize();" id="fileData" value="" placeholder="select file">
            <button type="submit" class="btn btn-primary" onclick="validateForm()">Upload</button>

            </div>

          </form>
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
</html>
