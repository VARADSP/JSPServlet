<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- JSP page index.jsp used to manage employee details 
@author:varad paralikar
Created Date: 2019/8/12
-->
<!DOCTYPE HTML>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee Manager </title>

<script type="text/javascript">
/*
function show is used to call display.jsp
return type : void
*/
function show(){
	window.location.replace("display.jsp");
}


</script>

<link rel="stylesheet" href="css/style2.css">
</head>

<body>

<div class="container" align="center">



<!-- Add employee button -->
<a id="modalBtn" class="button">Add Details</a>
<!-- Get details button -->
<a onclick="show()" id="detailsBtn" class="button">Get Details</a>
<!-- Clear employee data -->
<a class="button" href="ClearEmployeeData" style="text-decoration: none;display:inline-block;">Clear Details</a>

  <div id="simpleModal" class="modal">
      <div class="modal-content">
        <div class="modal-header">
          <span class="closeBtn">&times;</span>
          <h2>Employee Registration </h2>
        </div>
        <div class="modal-body">


<form method="get" action="welcome">
<!-- Table for displaying employee data -->
<table align="center">
<tr>
<td>Name</td><td><input type="text" name="name" required></td>
</tr>
<tr>
<td>Mobile No.</td><td><input type="tel" name="mn" required></td>
</tr>
<tr>
<td>Role</td><td><input type="text" name="role" required></td>
</tr>
<tr><td><input type="submit" value="Submit" class="button" align="center" style="position:relative;left:100px;;"/>
</td></tr>


</table>

</form>


            </div>
            <div class="modal-footer">
              <h3>Unikaihatsu Pvt Ltd @ 2019</h3>
            </div>


      </div>
  </div>

<script src="js/main.js"></script>




</div>
</body>
</html>