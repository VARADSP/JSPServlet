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
<title>User Data</title>
<!-- Semantic Ui -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<!-- Adding AJAX -->
<sx:head/>
<script type="text/javaScript">

function toggle(source) {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i] != source)
            checkboxes[i].checked = source.checked;
    }
}

function clearTable(){
	var input, filter, found, table, tr, td, i, j;
    input = document.getElementById("myInput");
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");

    document.getElementById('tableListHeaderId').innerHTML = "Table List";

    for (i = 0; i < tr.length; i++) {
    	tr[i].style.display = "";
    }
     document.getElementById("searchId").value = "";
     document.getElementById("searchName").value="";
     document.getElementById("searchCategory").value="";
     document.getElementById("searchSex").value="";
     document.getElementById("searchAddress").value="";
     document.getElementById("searchEmailId").value="";


}


function searchTable() {
    var inputId,inputName,inputCategory,inputSex,inputAddress,inputEmailId, filterId,filterName,filterCategory,filterSex,filterAddress,filterEmailId, found, table, tr, td, i, j;

    inputId = document.getElementById("searchId");
    inputName = document.getElementById("searchName");
    inputCategory = document.getElementById("searchCategory");
    inputSex = document.getElementById("searchSex");
    inputAddress = document.getElementById("searchAddress");
    inputEmailId = document.getElementById("searchEmailId");


    filterId = inputId.value.toUpperCase();
    filterName = inputName.value.toUpperCase();
    filterCategory = inputCategory.value.toUpperCase();
    filterSex = inputSex.value.toUpperCase();
    filterAddress = inputAddress.value.toUpperCase();
    filterEmailId = inputEmailId.value.toUpperCase();


    if(filterId.length == 0 && filterName.length == 0 && filterCategory.length==0 && filterSex.length == 0
    		&& filterAddress.length == 0 &&  filterEmailId.length == 0){
		console.log("No input");
		clearTable();
		return ;
    }

    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");


    for (i = 0; i < tr.length; i++) {

        td = tr[i].getElementsByTagName("td");

        for (j = 1; j < td.length; j++) {




            if ((td[1].innerHTML.toUpperCase() == filterId)) {

              found = true;
            }
        	if(td[2].innerText.toUpperCase() == filterName){

        		found = true;
        	}
        	if(td[3].innerText.toUpperCase() == filterCategory){

        		found = true;
        	}
        	if(td[4].innerText.toUpperCase() == filterSex){

        		found = true;
        	}
        	if(td[5].innerText.toUpperCase() == filterAddress){

        		found = true;
        	}
        	if(td[6].innerText.toUpperCase() == filterEmailId){

        		found = true;
        	}

        }

        if (found) {
            tr[i].style.display = "";
            found = false;

        } else {
        	if (tr[i].id != 'tableHeader'){
        		tr[i].style.display = "none";
        	}
        }


    }
	console.log(found);
    if(found == undefined){

		document.getElementById('tableListHeaderId').innerHTML = "Table List No Records Found !";
    }
}

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
thead, tbody { display: block; }

tbody {
    height: 200px;       /* Just for the demo          */
    overflow-y: auto;    /* Trigger vertical scroll    */
    overflow-x: hidden;  /* Hide the horizontal scroll */
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
User List Screen <br>
Welcome
<s:if test="#session.loggedInUser != null">
<s:property value="#session.loggedInUser"/>
</s:if>
</h3>

<a type="button" class="btn-5" href="logout" style="text-decoration: none;position:relative;float:right; background: red;padding: 0.7em 2em;color: #fff;border: 0;margin:10px;text-decoration:none;display:inline-block;">Logout</a>
</div>

<div class="clearfix"></div>




<div class="content clearfix">

<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'Admin' ">
<h3 style="color:gold;position:relative;left:20%;top:20%">Search Criteria</h3>
<div class="ui form" style="position:relative;left:20%;">
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
   <button class="ui inverted primary button" onclick="searchTable()"  style="position:relative;left:20px;">Search</button>

    <button class="ui inverted red button" onclick="clearTable()" style="position:relative;left:50px;">Clear</button>
 </div>

</div>
</s:if>
</s:if>
<h3 style="color:gold;position:relative;left:20%;top:20%" id="tableListHeaderId">Table List</h3>
<table id="myTable">
<tbody>
  <tr id='tableHeader'>
	<th><input type="checkbox" onclick="toggle(this);"  name="allUsers" /></th>
 	 <th>User ID </th>
    <th>Name</th>
    <th>Category</th>
    <th>Sex</th>
    <th>Address</th>
    <th>EmailId</th>
  </tr>

   <s:iterator  var="i" step="1" value="users">

  <tr>
   <td><input type="checkbox" name="<s:property value="name" />" /></td>
  <td data-th="Movie Title"><s:property value="userId" /></td>
    <td data-th="Movie Title"><s:property value="name" /></td>
    <td data-th="Genre"><s:property value="category" /></td>
    <td data-th="Year"><s:property value="sex" /></td>
    <td data-th="Gross"><s:property value="address" /></td>
      <td data-th="Gross"><s:property value="emailId" /></td>
  </tr>
 </s:iterator>
 	</tbody>
</table>
</div>



        <footer class="footer" style="border:none">
        <p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
      </footer>
	<!-- Semantic UI -->
      <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>