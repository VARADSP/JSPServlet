<!--
JSP page Display used to display basic user information
@author:varad paralikar
Created Date: 2019/8/14
-->
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
	<title>Display Users</title>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/table.css" />
</head>
<body>

<div style="background-color: #333;position:fixed;left:0;overflow: hidden;white-space: nowrap;top:0;width:100%">
<h3 style="float:left;color:white">Welcome ${sessionScope.username }</h3>
<a type="button" class="button" href="Logout" style="text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;">Logout</a>
</div>

<div style="margin-left:0;margin-top:100px;left:0;clear:both" class="table-wrapper">
<table class="fl-table">
<thead>
<tr>
<th>
Salutation
</th>
<th>
FirstName
</th>
<th>
MiddleName
</th>
<th>
LastName
</th>
<th>
Gender
</th>
<th>
Email
</th>
<th>
Date Of Birth
</th>
<th>
Address
</th>
<th>
Username
</th>
<th>
Password
</th>
<th>
Interest
</th>
<th>
OtherInterest
</th>
<th>
Action
</th>
</tr>
</thead>
<tbody>
<tr>
<td>
${sessionScope.salutation }
</td>

<td>
${sessionScope.firstName }
</td>

<td>
${sessionScope.middleName }
</td>

<td>
${sessionScope.lastName }
</td>

<td>
${sessionScope.gender }
</td>

<td>
${sessionScope.email }
</td>

<td>
${sessionScope.dateOfBirth }
</td>

<td>
${sessionScope.address }
</td>

<td>
${sessionScope.username }
</td>

<td>
${sessionScope.password }
</td>

<td>
${sessionScope.interest }
</td>
<td>
${sessionScope.otherInterest }
</td>

<td>
<a type="button" class="button" href="EditUserDetails?uid=${sessionScope.uid }" style="text-decoration: none;position:relative;float:right; background: green;color:fff;padding: 1em 2em;border: 0;">Edit</a>
</td>

</tr>


</tbody>
</table>

</div>
<h2 align="center">Successfully logged In </h2>
<div style=" background-color: #577;padding: 10px;text-align: center;color: white;bottom:0;left:0;position:fixed;width:100%;clear:both;">
<h1>Unikaihatsu Software Pvt Ltd. Copyright , All rights reserved</h1>
</div>
</body>

</html>