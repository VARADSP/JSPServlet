<!--
 JSP page success.jsp page displays success message
@author:varad paralikar
Created Date: 2019/8/29
-->

	<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html utf-8>
<html>
<head>
   <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta http-equiv="Content-Type"content="text/html;charset=utf-8">
<title>User Data Add User</title>
<!-- Semantic Ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<!-- Adding AJAX -->
<sx:head/>
<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
</head>
<style>
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
<h3 style="float:left;color:gold;position:absolute;left:0">
<s:if test="#session.loggedInUserType != null">
User Access Type : <s:property value="#session.loggedInUserType"/>
</s:if>
</h3>
<h3 style="float:left;color:gold;position:relative;left:43%;">
Add User Screen <br>
Welcome
<s:if test="#session.loggedInUser != null">
<s:property value="#session.loggedInUser"/>
</s:if>
</h3>

<a type="button" class="btn-5" href="logout" style="text-decoration: none;position:relative;float:right; background: red;padding: 0.7em 2em;color: #fff;border: 0;margin:10px;text-decoration:none;display:inline-block;">
<i class="fa fa-sign-out fa-lg" aria-hidden="true"></i>
Logout</a>
</div>

<div class="clearfix"></div>
<div class="content clearfix">
<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'Admin' ">
<h3 style="color:gold;position:relative;left:35%;top:20%">Register New User</h3>
<div class="ui form" style="position:relative;left:35%;">
  <div class="inline fields">
    <div class="field">
      <label class="ui olive label">User ID</label>
      <input type="text" placeholder="User ID" id="searchId">
    </div>
    <div class="field">
    <label class="ui olive label">Category</label>
    <select class="ui search dropdown" id="searchCategory">
      <option value="">---</option>
      <option value="admin">Admin</option>
       <option value="user">User</option>
    </select>
  </div>
  </div>
  <div class="inline fields">
    <div class="field">
      <label class="ui olive label">Name</label>
      <input type="text" placeholder="Name" id="searchName">
    </div>
    <div class="field">
      <label class="ui olive label">Address</label>
      <input type="text" placeholder="Address" id="searchAddress">
    </div>
  </div>
  <div class="inline fields">
    <div class="field" style="position:relative;left:20px;">
      <label class="ui olive label">Sex</label>
     <select class="ui search dropdown" id="searchSex">
      <option value="">---</option>
      <option value="male">Male</option>
       <option value="female">Female</option>
    </select>
    </div>
    <div class="field" style="position:relative;left:130px;">
      <label class="ui olive label">Email</label>
      <input type="text" placeholder="Email" id="searchEmailId">
    </div>
  </div>
 <div class="ui">
   <button class="ui inverted primary button" onclick="searchTable()"  style="position:relative;left:20px;">
 <i class="fa fa-plus fa-lg" aria-hidden="true"></i>
   Add User
   </button>
 </div>

</div>
</s:if>
</s:if>

</div>

        <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
       <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
	<!-- Semantic UI -->
      <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>