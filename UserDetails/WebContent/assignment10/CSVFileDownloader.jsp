<!--
 JSP page CSVFileDownloader displays table data with csv file creation ability
@author:varad paralikar
Created Date: 2019/8/23
-->
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML utf-8>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSV File Downloader</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style1.css" rel="stylesheet">
</head>
<body>
<!-- Include files from servlet -->
<c:import url="/assignment10/CSVFileDownloader" />
      <header class="header clearfix">
        <!-- Downloader heading -->
        <h3 class="text-muted" style="color:gold">CSV File Downloader</h3>
      </header>
<section>
  <a type="button" class="btn btn-primary" href="CSVFileDownloader?download=download" style="text-decoration: none; padding: 1em 2em;border: 0;position:relative;left:40%;">Download CSV File</a>
    <br/>
    <br/>
  <div class="tbl-header">
   <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>UserNo</th>
          <th>Salutation</th>
          <th>First Name</th>
          <th>Middle Initial</th>
          <th>Last Name</th>
          <th>Gender</th>
          <th>Email</th>
          <th>Date Of Birth</th>
          <th>Address</th>
          <th>User Id</th>
          <th>Password</th>
          <th>Area Of Interest</th>
          <th>Other Interest</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table>
      <tbody>
        <c:forEach items="${sessionScope.usersList}" var="user">
        <tr>
        <td>${user.userNo}</td>
          <td>${user.salutation}</td>
          <td>${user.firstName}</td>
          <td>${user.middleName}</td>
         <td>${user.lastName}</td>
         <td>${user.gender}</td>
         <td>${user.email}</td>
         <td>${user.dateOfBirth}</td>
         <td>${user.address}</td>
         <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.interest}</td>
        <td>${user.otherInterest}</td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</section>
       	<div id="result">
			</div>
	<span id="totalSize"></span>
      	<!-- Footer  -->
      <footer class="footer" style="border:none;color:black">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
</body>
</body>
</html>