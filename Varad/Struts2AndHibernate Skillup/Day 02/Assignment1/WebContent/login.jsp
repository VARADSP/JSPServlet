<!--
 JSP page login.jsp page displays login form
@author:varad paralikar
Created Date: 2019/8/29
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<style>
label{
display:block;
color:gold;
}
.logout-message{
position:relative;
left:40%;
margin:auto;
padding:10px;
top:10%;

}
</style>
<script>
//removes warning messages
 function removeWarnings(){
	document.getElementById('username').innerHTML = "Username";
	document.getElementById('password').innerHTML = "Password";

}
// clears content of action messages
 function clearcontent(elementID) {
     document.getElementById(elementID).innerHTML = "";
 }
</script>
</head>
<body>
 <header class="header clearfix">
        <!--  heading -->
        <h3 class="text-muted" style="color:gold">Struts 2 Login Application</h3>
      </header>

		<div id="errors" class="logout-message">
      <s:if test="hasActionMessages()">
		<h3 class="text-muted" style="color:gold">
			<s:actionmessage />
		</h3>
	</s:if>


	<s:if test="hasActionErrors()">
<h3 class="text-muted" style="color:red">
		<s:iterator value="actionErrors">
  		<s:property/><br/>
		</s:iterator>
		</h3>
	</s:if>
	</div>


    <s:form cssClass="form" action="loginAuthentication.action" method="post">
    	<s:hidden name="loginAttempt" value="%{'1'}" />

		<label id="username">

		Username

		</label>

  <s:textfield cssClass="input" onchange="removeWarnings()" name="userName" onclick="removeWarnings();clearcontent('errors')" placeholder="Username" />
  <br>
  <br>
  <br>
		<label id="password">
		Password
		</label>

  <s:password cssClass="input" name="password" onchange="removeWarnings()" onclick="removeWarnings();clearcontent('errors')" placeholder="Password" />

	<s:submit cssClass="btn btn-primary btn-block btn-large" label="Login" name="submit" />
      </s:form>


        <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>

</body>
</html>