<!--
 JSP page success.jsp page displays success message
@author:varad paralikar
Created Date: 2019/8/29
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
</head>
<style>

label{
display:block;
color:gold;
position:relative;
left:40%;
margin:auto;
padding:10px;

}


.btn-5 {

  border: 0 solid;
  box-shadow: inset 0 0 20px rgba(255, 255, 255, 0);
  outline: 1px solid;
  outline-color: rgba(255, 255, 255, .5);
  outline-offset: 0px;
  text-shadow: none;
  transition: all 1250ms cubic-bezier(0.19, 1, 0.22, 1);
}

.btn-5:hover {
  border: 1px solid;
  box-shadow: inset 0 0 20px rgba(255, 255, 255, .5), 0 0 20px rgba(255, 255, 255, .2);
  outline-color: rgba(255, 255, 255, 0);
  outline-offset: 15px;
  text-shadow: 1px 1px 2px #427388;
}
</style>

<body onload="disableBackButton()">

<!-- Header -->
<div style="background-color: #333;opacity:0.8;position:fixed;left:0;overflow: hidden;white-space: nowrap;top:0;width:100%">
<h3 style="float:left;color:gold;position:absolute;left:43%;">

Welcome
<s:if test="#session.loggedInUser != null">
<s:property value="#session.loggedInUser"/>


</s:if>
</h3>

<a type="button" class="btn-5" href="logout" style="text-decoration: none;position:relative;float:right; background: red;padding: 0.7em 2em;color: #fff;border: 0;margin:10px;text-decoration:none;display:inline-block;">Logout</a>
</div>

<div class="clearfix"></div>

<div class="content clearfix">

<table>
  <tr>
    <th>FirstName</th>
    <th>MiddleName</th>
    <th>LastName</th>
    <th>Gender</th>
    <th>EmailId</th>
    <th>Contact No</th>

  </tr>

   <s:iterator  var="i" step="1" value="users">

  <tr>
    <td data-th="Movie Title"> <s:property value="firstName" /></td>
    <td data-th="Genre"><s:property value="middleName" /></td>
    <td data-th="Year"><s:property value="lastName" /></td>
    <td data-th="Gross"><s:property value="gender" /></td>
      <td data-th="Gross"><s:property value="emailId" /></td>
        <td data-th="Gross"><s:property value="contactNo" /></td>
  </tr>

 </s:iterator>
</table>


 <s:iterator  var="i" step="1" value="users">
 <s:property value="firstName" />
 </s:iterator>





	</div>


        <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
</body>
</html>