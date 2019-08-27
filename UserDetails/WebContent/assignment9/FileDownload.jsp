<!--
 JSP page FileDownload displays uploaded files on server
@author:varad paralikar
Created Date: 2019/8/22
-->
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE HTML utf-8>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Download</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
</head>
<body>
<!-- Include files from servlet -->
<c:import url="/assignment9/FileDownload" />
     <header class="header clearfix">
        <!-- Downloader heading -->
        <h3 class="text-muted" style="color:gold">File Downloader</h3>
      </header>
<section>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>File No</th>
          <th>File Name</th>
          <th>File Size</th>
          <th>File Path</th>
          <th>Download</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table>
      <tbody>
        <c:forEach items="${sessionScope.fileList}" var="file">
        <tr>
          <td>${file.fileNo}</td>
          <td>${file.fileName}</td>
          <td>${file.fileSize } </td>
          <td>${file.fileUrl }</td>
          <td>
          <a type="button" class="btn btn-primary" href="FileDownload?fileUrl=${file.fileUrl }&fileName=${file.fileName}" style="text-decoration: none; padding: 1em 2em;border: 0;">Download</a>
          </td>
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
      <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
</body>
</body>
</html>