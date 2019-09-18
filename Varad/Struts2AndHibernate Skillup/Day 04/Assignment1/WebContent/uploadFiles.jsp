<!--
 JSP page uploadFiles.jsp page displays login form
@author:varad paralikar
Created Date: 2019/8/02
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Files</title>

<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">


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


	function removeErrors(x) {
		  x.innerHTML = "";
		}


</script>
<style>
.chooseFileBtn{
 padding: 10px;
    background: #6B8E23;
    display: table;
    color: #fff;
}



</style>
</head>
<body>


 <div class="container">
      <header class="header clearfix">
        <nav>
       </nav>
        <!-- Uploader heading -->
        <h3 class="text-muted">File Uploader <i class="fa fa-cloud-upload fa-lg" aria-hidden="true"></i></h3>
      </header>
        <main role="main">
        <div class="jumbotron">
        <!-- form to upload file -->

	<div id="errors" onmouseover="removeErrors(this)" class="logout-message">
      <s:if test="hasActionMessages()">
		<h3 class="text-muted" style="color:gold">
			<s:actionmessage />
		</h3>
	</s:if>
	</div>
          <h3 class="display-3">Upload Your Files</h3>
          <form id="myForm" action="chooseImage" ENCTYPE="multipart/form-data" method="post">
            <div class="form-group">
              <label id="fileLabel">Select Your File</label>
              <label class="chooseFileBtn">
		<input type="file"  onchange="alertFileSize();"  class="form-control hide-file" name="file" id="file" />

		</label>





		<br />
		<button type="submit" onclick="validateForm()" name="submit" class="btn btn-success" aria-label="Left Align">
 <span class="fa fa-fighter-jet fa-lg" aria-hidden="true"></span>Upload
 </button>

		<button type="button" value="Reset" name="Reset" class="btn btn-primary"
			onclick="buttonReset();">
			 <i class="fa fa-trash fa-lg" aria-hidden="true"></i>
			Clear</button>
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

    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
<script src="semantic/dist/semantic.min.js"></script>
</body>
</html>