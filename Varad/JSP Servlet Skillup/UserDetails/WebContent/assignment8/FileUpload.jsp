<!--
 JSP page FileUpload is used to upload files
@author:varad paralikar
Created Date: 2019/8/21
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>File Uploader</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
<script>
/*
function validateForm is used to check if user has selected file to upload
return type:void
*/
	function validateForm()
{
			var fileLabel = document.getElementById('fileLabel');
          if(document.getElementById('file').value.length == 0){

        		fileLabel.innerHTML = "Please select a file to upload !";
        		fileLabel.style.color = "red";

        		event.preventDefault();
           }
          else{
        	  fileLabel.innerHTML = "Select Your File";
        	  fileLabel.style.color = "black";
        			// Check browser support for session storage
        	  if (typeof(Storage) !== "undefined") {
        		  var inpFiles = document.getElementById('file');
        			for (var i = 0; i < inpFiles.files.length; ++i) {
        			    var size = inpFiles.files.item(i).size;
                	    sessionStorage.setItem("fileSize", size);
        			}

        	  } else {
					// do nothing
        	  }
          }
}
	/*
	function alertFileSize alerts user if size limit is reached !
	return type:void
	*/
	function alertFileSize(){
		var inpFiles = document.getElementById('file');
		for (var i = 0; i < inpFiles.files.length; ++i) {
		    var size = inpFiles.files.item(i).size;

		    if(size > 20971520){
		    	var fileLabel = document.getElementById('fileLabel');
		    	fileLabel.innerHTML = "File size exceeded ! Size Limit is 20MB";
		    	customReset();
		    }
		}
	}
	/*
	function customReset resets file input!
	return type:void
	*/
	function customReset() {
		var fileLabel = document.getElementById('fileLabel');
		document.getElementById("file").value = "";

   	  fileLabel.style.color = "black";
	}
	/*
	function buttonReset resets file input!
	return type:void
	*/
	function buttonReset() {
		var fileLabel = document.getElementById('fileLabel');
		document.getElementById("file").value = "";
		 fileLabel.innerHTML = "Select Your File";
   	  fileLabel.style.color = "black";
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
          <form id="myForm" action="FileUpload" ENCTYPE="multipart/form-data" method="post">
            <div class="form-group">
              <label id="fileLabel">Select Your File</label>
		<input type="file" onchange="alertFileSize();"  class="form-control" name="file" id="file" /><br /> <input
			type="submit" class="btn btn-success" value="Upload" onclick="validateForm()" name="submit" placeholder="Select File" />
		<button type="button" value="Reset" name="Reset" class="btn btn-primary"
			onclick="buttonReset();">Clear</button>
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