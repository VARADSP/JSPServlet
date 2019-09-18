<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- JSP page display used to search employees and display the details 
@author:varad paralikar
Created Date: 2019/8/12
-->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<!-- Linking css -->
<link rel="stylesheet" href="css/style2.css">
</head>
<body>



<div class="container">

<form method="get" action="DisplayEmployee">

<h1 align="center">Employee Details</h1>
<!-- Input name -->
Name&nbsp;</td><td><input required type="text" id="inputName" name="name1"  placeholder="Enter name to search" style="height:25px;"></td><td><input class="button" type="submit" value="Search">

</form>
</div>

</body>

<br><br><br><br>

<!-- Go back button -->
<a type="button" class="button" href="index.jsp" style="text-decoration: none;">Go Back</a>

</html>