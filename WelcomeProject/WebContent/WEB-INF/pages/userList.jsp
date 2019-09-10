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
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

<!-- Adding AJAX -->
<sx:head/>
<script type="text/javaScript">
window.addEventListener('load', function() {
    console.log('All assets are loaded');

	 var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	 var rows = document.querySelectorAll('tr');


	 var checkedIds = "";

	    for (var i = 1; i < checkboxes.length; i++) {

	    			if(rows[i].getElementsByTagName("td")[3].innerText == 'Admin'){

						var button =rows[i].getElementsByTagName("td")[7].getElementsByTagName("button");
						button.item(0).disabled = true;

	   				}
	    		}

});


function handleChange(checkbox) {



	 var ubtn1 = document.getElementById('updateBtn');
	 var ubtn2 = document.getElementById('deleteBtn');
    if(checkbox.checked == true){
    	console.log("in handle checked");
    	 var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    	 var rows = document.querySelectorAll('tr');

    	 var howManyChecked = 0;
    	 var whichOneIsChecked=0;

    	 var checkedIds = "";

    	    for (var i = 1; i < checkboxes.length; i++) {
    	    		if(checkboxes[i].checked){
    	    			howManyChecked = howManyChecked + 1;
    	    			whichOneIsChecked = i ;
    	    			checkedIds = checkedIds + checkboxes[whichOneIsChecked].id + ",";

    	    			if(rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin'){

    	    				console.log("In the condition");



							ubtn2.disabled = true;

							console.log(ubtn2);

							var name = document.getElementById('updateBtn').name;
							if(rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin' && rows[whichOneIsChecked].getElementsByTagName("td")[1].innerText != name ){


								ubtn1.disabled = true;

			   				}


							return ;
    	   				}
    	    		}
    		}



    }
    else{
    	console.log("in handle unchecked");
    	ubtn1.disabled = false;
    	ubtn2.disabled = false;

    }
}


function enableUser(element){

	var id = element.name;

	window.location="enable?id="+id;

}

function disableUser(element){

	var id = element.name;


	window.location="disable?id="+id;

}


function detailsHref(){


	console.log("In details href ");

	var ubtn = document.getElementById('detailsBtn');


	 var checkboxes = document.querySelectorAll('input[type="checkbox"]');

	 var howManyChecked = 0;
	 var whichOneIsChecked=0;

	    for (var i = 1; i < checkboxes.length; i++) {
	    		if(checkboxes[i].checked){
	    			howManyChecked = howManyChecked + 1;
	    			whichOneIsChecked = i ;
	    		}

		}

	    if(howManyChecked > 1){
	    	alert("Please select only one user to view details !");
	    }
	    else if(howManyChecked == 0){
	    	alert("Please select a user to view details !");
	    }
	    else{
	    	console.log("do details of " + checkboxes[whichOneIsChecked].id);

			window.location="details?id="+checkboxes[whichOneIsChecked].id;


	    }

}




function deleteHref(){

	var ubtn = document.getElementById('deleteBtn');


	 var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	 var rows = document.querySelectorAll('tr');

	 var howManyChecked = 0;
	 var whichOneIsChecked=0;

	 var checkedIds = "";

	    for (var i = 1; i < checkboxes.length; i++) {
	    		if(checkboxes[i].checked){
	    			howManyChecked = howManyChecked + 1;
	    			whichOneIsChecked = i ;
	    			checkedIds = checkedIds + checkboxes[whichOneIsChecked].id + ",";

	    			if(rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin'){
	   					alert("Can not delete admin !")
	   					return ;
	   				}
	    		}
		}


	    if(howManyChecked == 0){
	    	alert("Please select a user to delete !");
	    }
	    else{
	    	console.log("do delete of " + checkedIds);

			window.location="delete?id="+checkedIds;
	    }

}


function updateHref(){

	var ubtn = document.getElementById('updateBtn');
	var name = document.getElementById('updateBtn').name;

	 var checkboxes = document.querySelectorAll('input[type="checkbox"]');
	 var rows = document.querySelectorAll('tr');

	 var howManyChecked = 0;
	 var whichOneIsChecked=0;

	    for (var i = 1; i < checkboxes.length; i++) {
	    		if(checkboxes[i].checked){
	    			howManyChecked = howManyChecked + 1;
	    			whichOneIsChecked = i ;

	    			if(rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin' && rows[whichOneIsChecked].getElementsByTagName("td")[1].innerText != name ){
	   					alert("Can not update other admins !")
	   					return ;
	   				}

	    		}

		}

	    if(howManyChecked > 1){
	    	alert("Please select only one user to update !");
	    }
	    else if(howManyChecked == 0){
	    	alert("Please select a user to update !");
	    }
	    else{
	    	console.log("do update of " + checkboxes[whichOneIsChecked].id);

			window.location="update?id="+checkboxes[whichOneIsChecked].id;


	    }


}


function operation() {
	var ubtn = document.getElementById('update');
	var dbtn = document.getElementById('detail');
	checkboxes = document.getElementsByName('check[]');
	var checked;
	var count = 0;
	for (var i = 0; i < checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			checked = checkboxes[i];
			count++;
		}
	}
	ubtn.href = '/WelcomeProject/editaction.action?uname=' + checked.value;
	dbtn.href = '/WelcomeProject/detailaction.action?uname='
			+ checked.value;

	if (count > 1) {
		ubtn.disabled = true;
		dbtn.disabled = true;

	} else {
		ubtn.disabled = false;
		dbtn.disabled = false;
	}

}





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
	document.getElementById('myTable').style.display = "";
	document.getElementById('adminControls').style.display = "";

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


            if ((td[1].innerHTML.toUpperCase() == filterId) &&
            		(td[4].innerText.toUpperCase() == filterSex)) {
                found = true;
              }
            if((td[2].innerText.toUpperCase() == filterName) &&
            		(td[4].innerText.toUpperCase() == filterSex)){
            	found = true;
            }
            if((td[2].innerText.toUpperCase() == filterName) &&
            		(td[4].innerText.toUpperCase() == filterSex) &&
            		(td[1].innerHTML.toUpperCase() == filterId)){
            	found = true;
            }
            if((td[3].innerText.toUpperCase() == filterCategory) &&
            		(td[1].innerHTML.toUpperCase() == filterId)){
        		found = true;
        	}
            if((td[3].innerText.toUpperCase() == filterCategory) &&
            		(td[2].innerText.toUpperCase() == filterName)){
        		found = true;
        	}

            if((td[3].innerText.toUpperCase() == filterCategory) &&
            		(td[2].innerText.toUpperCase() == filterName) &&
            		(td[1].innerHTML.toUpperCase() == filterId)){
        		found = true;
        	}







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
		document.getElementById('myTable').style.display = "none";
		document.getElementById('adminControls').style.display = "none";


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

td{
  width: 140px;
   word-break: break-all;
}

tbody {
    height: 150px;       /* Just for the demo          */
    overflow-y: auto;    /* Trigger vertical scroll    */
    overflow-x: auto;  /* Hide the horizontal scroll */
}

@media
only screen and (max-width: 760px),
(min-device-width: 768px) and (max-device-width: 1024px)  {

	/* Force table to not be like tables anymore */
	table, thead, tbody, td, tr {
		display: block;
	}
	th{
	display:none;
	}
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr {
		position: absolute;
		top: -9999px;
		left: -9999px;
	}

	tr { border: 1px solid #ccc; }

	td {
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee;
		position: relative;
		padding-left: 50%;
	}

	td:before {
		/* Now like a table header */
		position: absolute;
		/* Top/left values mimic padding */
		top: 6px;
		left: 6px;
		width: 45%;
		padding-right: 10px;
		white-space: nowrap;
	}

		/*
	Label the data
	*/
	td:nth-of-type(1):before { content: "Select User"; }
	td:nth-of-type(2):before { content: "User ID"; }
	td:nth-of-type(3):before { content: "Name"; }
	td:nth-of-type(4):before { content: "Category"; }
	td:nth-of-type(5):before { content: "Sex"; }
	td:nth-of-type(6):before { content: "Address"; }
	td:nth-of-type(7):before { content: "EmailId"; }

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

<a type="button" class="btn-5" href="logout" style="text-decoration: none;position:relative;float:right; background: red;padding: 0.7em 2em;color: #fff;border: 0;margin:10px;text-decoration:none;display:inline-block;">
<i class="fa fa-sign-out fa-lg" aria-hidden="true"></i>
Logout</a>
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
   <button class="ui inverted primary button" onclick="searchTable()"  style="position:relative;left:20px;">
 <i class="fa fa-search fa-lg" aria-hidden="true"></i>
   Search</button>

    <button class="ui inverted red button" onclick="clearTable()" style="position:relative;left:50px;">
        <i class="fa fa-trash fa-lg" aria-hidden="true"></i>
    Clear
    </button>
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

<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'Admin' ">
<th>Enable/Disable User</th>
</s:if>
</s:if>

  </tr>

   <s:iterator  var="i" step="1" value="users">

  <tr>
   <td>
<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'User' ">
<s:if test="isDisabled == 'true' ">

   <input type="checkbox" disabled checked id="<s:property value="id" />" />
</s:if>
<s:else>
   <input type="checkbox" checked id="<s:property value="id" />" />
</s:else>
</s:if>
<s:else>
 <s:if test="isDisabled == 'true' ">

   <input type="checkbox" disabled onchange='handleChange(this);' onclick='handleChange(this);'  id="<s:property value="id" />" />
</s:if>
<s:else>
   <input type="checkbox" onchange='handleChange(this);' onclick='handleChange(this);' id="<s:property value="id" />" />
</s:else>
</s:else>
</s:if>

   </td>
  <td data-th="Movie Title"><s:property value="userId" /></td>
    <td data-th="Movie Title"><s:property value="name" /></td>
    <td data-th="Genre" id="category"><s:property value="category" /></td>
    <td data-th="Year"><s:property value="sex" /></td>
    <td data-th="Gross"><s:property value="address" /></td>
      <td data-th="Gross"><s:property value="emailId" /></td>

<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'Admin' ">
      <td data-th="Gross">
<s:if test="isDisabled == 'true' ">
    <button class="ui green button" name="<s:property value="id" />" id="enableBtn" onclick="enableUser(this)" style="position:relative;left:30px;">
        <i class="fa fa-toggle-on fa-lg" aria-hidden="true"></i>
    Enable
    </button>
</s:if>
<s:else>
    <button class="ui red button" name="<s:property value="id" />" id="disableBtn" onclick="disableUser(this)" style="position:relative;left:30px;">
        <i class="fa fa-ban fa-lg" aria-hidden="true"></i>
    Disable
    </button>
</s:else>
      </td>

</s:if>
</s:if>

  </tr>
 </s:iterator>
 	</tbody>
</table>

<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'Admin' ">
<div class="ui buttons" id="adminControls" style="position:relative;left:59%;">
   <a class="ui green button" href="add" style="position:relative;left:10px;">
 <i class="fa fa-plus fa-lg" aria-hidden="true"></i>
   Register</a>

    <button class="ui violet button" onclick="updateHref()" name="<s:property value="#session.loggedInUser"/>" id="updateBtn" style="position:relative;left:20px;">
        <i class="fa fa-edit fa-lg" aria-hidden="true"></i>
    Update
    </button>

    <button class="ui red button" onclick="deleteHref()" id="deleteBtn"  style="position:relative;left:30px;">
        <i class="fa fa-trash fa-lg" aria-hidden="true"></i>
    Delete
    </button>

    <button class="ui blue button" onclick="detailsHref()" id="detailsBtn"  style="position:relative;left:40px;">
        <i class="fa fa-eye fa-lg" aria-hidden="true"></i>
    Details
    </button>
 </div>
</s:if>
</s:if>
<s:if test="#session.loggedInUserType != null">
<s:if test="#session.loggedInUserType == 'User' ">
<div class="ui buttons" id="userControls" style="position:relative;left:53%;">
     <button class="ui violet button" onclick="updateHref()" name="<s:property value="#session.loggedInUser"/>" id="updateBtn" style="position:relative;left:20px;">
        <i class="fa fa-edit fa-lg" aria-hidden="true"></i>
    Update
    </button>

    <button class="ui blue button" onclick="detailsHref()" id="detailsBtn"  style="position:relative;left:40px;">
        <i class="fa fa-eye fa-lg" aria-hidden="true"></i>
    Details
    </button>
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