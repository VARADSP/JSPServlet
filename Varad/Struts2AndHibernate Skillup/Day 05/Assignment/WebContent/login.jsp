<!--
 JSP page login.jsp displays login page
@author:varad paralikar
Created Date: 2019/9/5
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html utf-8>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style1.css" />
<style>
label {
	display: block;
	color: gold;
}

.logout-message {
	position: relative;
	left: 40%;
	margin: auto;
	padding: 10px;
	top: 10%;
}
</style>
<script>

window.addEventListener('load', function() {
	 // Check browser support
    if (typeof(Storage) !== "undefined") {
      // Retrieve
      var language = sessionStorage.getItem("language");

      console.log("From session " + language);

      document.getElementById("language").value = language;

    } else {

    }


});


	//removes warning messages
	function removeWarnings() {

	}
	// clears content of action messages
	function clearcontent(elementID) {
		document.getElementById(elementID).innerHTML = "";
	}

	function SelectedValue(sel) {
	    var value = sel.options[sel.selectedIndex].value;

	    console.log(value);


	 // Check browser support
	    if (typeof(Storage) !== "undefined") {
	      // Store
	      sessionStorage.setItem("language", value);

	    } else {
	      document.getElementById("result").innerHTML = "Sorry, your browser does not support Web Storage...";
	    }
	    //Do something depending on value
	}
</script>
</head>
<body>
	<header class="header clearfix">
		<!--  heading -->
		<h3 class="text-muted" style="color: gold">
			<s:text name="global.welcome"></s:text>
		</h3>
		<s:form action="welcome" style="float:right;">
			<s:select id="language" onchange="SelectedValue(this)" list="#{'en_US':'English', 'jp_JP':'Japanese'}" name="appLocale"
				key="global.selectlocale"></s:select><s:submit key="global.submit" name="submit"></s:submit>
		</s:form>
	</header>

	<div id="errors" class="logout-message">
		<s:if test="hasActionMessages()">
			<h3 class="text-muted" style="color: gold">
				<s:actionmessage />
			</h3>
		</s:if>


		<s:if test="hasActionErrors()">
			<h3 class="text-muted" style="color: red">
				<s:iterator value="actionErrors">
					<s:property />
					<br />
				</s:iterator>
			</h3>
		</s:if>
	</div>


	<s:form cssClass="form" action="loginAuthentication.action"
		method="post">
		<s:hidden name="loginAttempt" value="%{'1'}" />


		<label id="username"> <s:text name="global.username"></s:text>

		</label>

		<s:textfield cssClass="input" onchange="removeWarnings()"
			name="loginBean.userName"
			onclick="removeWarnings();clearcontent('errors')" />
		<br>
		<br>
		<br>
		<label id="password"> <s:text name="global.password"></s:text>
		</label>

		<s:password cssClass="input" name="loginBean.password"
			onchange="removeWarnings()"
			onclick="removeWarnings();clearcontent('errors')" />

		<s:submit cssClass="btn btn-primary btn-block btn-large" label="Login"
			name="submit" key="global.submit">

		</s:submit>
	</s:form>


	<footer class="footer" style="border: none">
		<p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
	</footer>

</body>
</html>