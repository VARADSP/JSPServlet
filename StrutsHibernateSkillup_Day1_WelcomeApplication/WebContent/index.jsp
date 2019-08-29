<!--
 JSP page index.jsp page home page for application
@author:varad paralikar
Created Date: 2019/8/27
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Struts 2 Welcome Application</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
<style>
label{
color: #B4886B;
font-weight: bold;
display: inline-block;
width: 150px;
font-size:35px;
}
</style>
</head>
<body>
<div class="container">
   <header class="header clearfix">
        <!--  heading -->
        <h3 class="text-muted" style="color:gold">Struts 2 Welcome Application</h3>
      </header>
      <section>
		<div class="row">
		<br>
		<br>

		<form class="form-group form-inline" action="insertData" method="post">

		<div class="input-group mb-3">


  		<label for="exampleInputName">Name</label> <input autofocus type="text" name="name" class="form-control input-lg" placeholder="Please Enter Name" aria-label="name" aria-describedby="basic-addon1" required>


		<input type="submit" class="btn btn-primary btn-lg" style="position:relative;left:30%;margin-top:20%;" value="Submit">

		</div>

		</form>
		</div>

	</section>
	    <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
      </div>
</body>
</html>