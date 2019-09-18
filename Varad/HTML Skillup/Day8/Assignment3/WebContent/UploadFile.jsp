<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!-- JSP page uploadFile used to show progress bar
@author:varad paralikar
Created Date: 2019/8/12
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=U  TF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Progress</title>



    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

<script>

var isCompleted = false;

/*
function cancel is used to cancel the upload operation
return type:void
*/
function cancel() {
	if(isCompleted == false){
		alert("Operation canceled!");
		  window.history.back();

	}
	else{
		alert("Upload completed!");
	}

}


/*
function error displays errors
return type:void
*/
function error(){

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');

	status.innerHTML = "Error occurred while uploading file!";
	progressBar.style.width = 0+"%";

}


/*
function operationCompleted is called upon file uploaded to show total bytes uploaded
return type:void
*/
function operationCompleted(){

	console.log(size);

	var displaySize = document.getElementById('totalSize');

	displaySize.innerHTML = "Total Bytes Read " + size;

	isCompleted = true;

	var progressBar = document.getElementById('progressBar');
	progressBar.innerHTML = "100%";

}
var counter = 0;


/*
function incrementNumber displays progress
return type:void
*/
function incrementNumber() {
	  setTimeout(function(){
		  var progressBar = document.getElementById('progressBar');
		var i =   parseInt(progressBar.innerHTML);

		counter +=10;

		i = counter + i;

		i=i+85;

		console.log(i);




		progressBar.innerHTML = i.toString()+"%";


	  }, 500);
	}


/*
function window.onload called upon window loading
return type:void
*/
window.onload = function () {

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');
	status.innerHTML = "Uploading File";


	progressBar.style.width ="20%";

	incrementNumber();
	var i=0;


	for(i=0;i<=100;i++){

		progressBar.style.width = i+"%";

	}
	status.innerHTML = "File Uploaded!"




	}
</script>

</head>



<body>

<div class="container">
      <header class="header clearfix">
        <nav>

        </nav>
        <h3 class="text-muted">


        File Uploader</h3>
      </header>
           <main role="main">

        <div class="jumbotron">
    <a type="button" style="float:right;" href="index.jsp" class="btn btn-info">Go Back</a>
            <div class="form-group">
              <label id="status">Upload Progress </label>


   <!-- PRogress Bar -->
             <div class="progress" style="margin-bottom:50px;">
             <div id="progressBar" class='progress-bar progress-bar-striped active' style='width:5%;'>
				5%
			</div>

			</div>

         	<button type="reset" onclick="cancel()" class="btn btn-danger">Cancel</button>

			<span id="totalSize"></span>






            </div>






        </div>

        <div class="row marketing">
          <div class="col-lg-6">
            <div id="bookmarksResults">


            </div>


            </div>


        </div>

      </main>

      <footer class="footer">

        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>

    </div> <!-- /container -->


</body>
</html>