<!--
 JSP page welcome page prints values from struts
@author:varad paralikar
Created Date: 2019/8/27
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Message Page</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
</head>
<style>
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
    white-space: pre;


}

</style>
<body>
<div class="container">
   <header class="header clearfix">
        <!--  heading -->
        <h3 class="text-muted" style="color:gold">Struts 2 Welcome Application</h3>
      </header>

<section>
<div class="row">
<!-- Bean class -->
<h1>
<s:bean name="com.uks.varad.struts.day1.assignment1.bean.WelcomeBean" var="welcomeBean" />
<s:property value="#welcomeBean.message" />
</h1>
</div>
</section>
<section>
<div class="row">
<!--  property from action class -->
<h1>
 Name : <s:property value = "name"/>
</h1>
</div>
</section>
<a type="button" style="float:right;" href="index.jsp" class="btn btn-info btn-lg">Go Back</a>

    <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
</div>
</body>
</html>