<!--
JSP page error is used to display error if user is already login
@author:varad paralikar
Created Date: 2019/8/14
-->
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html lang="en">
<head>
	<title>Login Form</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Stylesheets for error page -->

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>

<body>

	<div class="limiter">
		<div class="container-login100">
<!-- Message if already login -->
			<h1 style="color:red;">	You are already logged in ! </h1>



			<form action="Logout" method="post">
   				 <input class="login100-form-btn" type="submit" value="Logout" />
   				 <!-- Logout button  -->

			</form>
		</div>
</div>


<!-- JQeury for logout button  -->

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>