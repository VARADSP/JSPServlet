<!--
 JSP page userList displays user list
@author:varad paralikar
Created Date: 2019/9/5
-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html utf-8>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>User Data</title>
<!-- Semantic Ui -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<!-- Adding AJAX -->
<sx:head />
<script type="text/javaScript">
//called on load event
	window.addEventListener('load', function() {
		console.log('All assets are loaded');
		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		var rows = document.querySelectorAll('tr');
		var checkedIds = "";
		for (var i = 1; i < checkboxes.length; i++) {
			if (rows[i].getElementsByTagName("td")[3].innerText == 'Admin') {

				var button = rows[i].getElementsByTagName("td")[7]
						.getElementsByTagName("button");
				button.item(0).disabled = true;

			}
		}

	});


//function handleChange gets invoked upon changing checkbox selection
	function handleChange(checkbox) {

		var ubtn1 = document.getElementById('updateBtn');
		var ubtn2 = document.getElementById('deleteBtn');
		if (checkbox.checked == true) {
			console.log("in handle checked");
			var checkboxes = document
					.querySelectorAll('input[type="checkbox"]');
			var rows = document.querySelectorAll('tr');

			var howManyChecked = 0;
			var whichOneIsChecked = 0;

			var checkedIds = "";

			for (var i = 1; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					howManyChecked = howManyChecked + 1;
					whichOneIsChecked = i;
					checkedIds = checkedIds + checkboxes[whichOneIsChecked].id
							+ ",";

					if (rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin') {

						console.log("In the condition");

						ubtn2.disabled = true;

						console.log(ubtn2);

						var name = document.getElementById('updateBtn').name;
						if (rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin'
								&& rows[whichOneIsChecked]
										.getElementsByTagName("td")[1].innerText != name) {

							ubtn1.disabled = true;

						}

						return;
					}
				}
			}

		} else {
			console.log("in handle unchecked");
			ubtn1.disabled = false;
			ubtn2.disabled = false;

		}
	}
//function enables users
	function enableUser(element) {
		var id = element.name;
		// Get the modal
		var modal = document.getElementById("myModal");
		var modalContents = document.getElementById("modalContents");
		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];
		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		  modal.style.display = "none";
		  window.location = "enable?id=" + id;
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";
		    window.location = "enable?id=" + id;
		  }
		}
		 modalContents.innerHTML = "User enabled successfully ! ";
		 modal.style.display = "block";
	}
//disables users
	function disableUser(element) {
		var id = element.name;
		// Get the modal
		var modal = document.getElementById("myModal");

		var modalContents = document.getElementById("modalContents");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
		  modal.style.display = "none";

			window.location = "disable?id=" + id;
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		  if (event.target == modal) {
		    modal.style.display = "none";

			window.location = "disable?id=" + id;
		  }
		}

		 modalContents.innerHTML = "User disabled successfully ! ";

		 modal.style.display = "block";



	}
//shows details of users
	function detailsHref() {

		console.log("In details href ");

		var ubtn = document.getElementById('detailsBtn');

		var checkboxes = document.querySelectorAll('input[type="checkbox"]');

		var howManyChecked = 0;
		var whichOneIsChecked = 0;

		for (var i = 1; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				howManyChecked = howManyChecked + 1;
				whichOneIsChecked = i;
			}

		}

		if (howManyChecked > 1) {

			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}

			 modalContents.innerHTML = "Please select only one user to view details !";

			 modal.style.display = "block";



		} else if (howManyChecked == 0) {
			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}

			 modalContents.innerHTML = "Please select a user to view details !";

			 modal.style.display = "block";
		} else {
			console.log("do details of " + checkboxes[whichOneIsChecked].id);

			window.location = "details?id=" + checkboxes[whichOneIsChecked].id;

		}

	}
//deletes users
	function deleteHref() {

		var ubtn = document.getElementById('deleteBtn');

		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		var rows = document.querySelectorAll('tr');

		var howManyChecked = 0;
		var whichOneIsChecked = 0;

		var checkedIds = "";

		for (var i = 1; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				howManyChecked = howManyChecked + 1;
				whichOneIsChecked = i;
				checkedIds = checkedIds + checkboxes[whichOneIsChecked].id
						+ ",";

				if (rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin') {


					// Get the modal
					var modal = document.getElementById("myModal");

					var modalContents = document.getElementById("modalContents");

					// Get the <span> element that closes the modal
					var span = document.getElementsByClassName("close")[0];

					// When the user clicks on <span> (x), close the modal
					span.onclick = function() {
					  modal.style.display = "none";
					}

					// When the user clicks anywhere outside of the modal, close it
					window.onclick = function(event) {
					  if (event.target == modal) {
					    modal.style.display = "none";
					  }
					}

					 modalContents.innerHTML = "Can not delete admin ! ";

					 modal.style.display = "block";



					return;
				}
			}
		}

		if (howManyChecked == 0) {

			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}

			 modalContents.innerHTML = "Please select a user to delete !";

			 modal.style.display = "block";


		} else {
			console.log("do delete of " + checkedIds);


			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
				window.location = "delete?id=" + checkedIds;
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
				window.location = "delete?id=" + checkedIds;
			  }
			}

			 modalContents.innerHTML = "User deleted successfully !";

			 modal.style.display = "block";

		}

	}

	function updateHref() {

		var ubtn = document.getElementById('updateBtn');
		var name = document.getElementById('updateBtn').name;

		var checkboxes = document.querySelectorAll('input[type="checkbox"]');
		var rows = document.querySelectorAll('tr');

		var howManyChecked = 0;
		var whichOneIsChecked = 0;

		for (var i = 1; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				howManyChecked = howManyChecked + 1;
				whichOneIsChecked = i;

				if (rows[whichOneIsChecked].getElementsByTagName("td")[3].innerText == 'Admin'
						&& rows[whichOneIsChecked].getElementsByTagName("td")[1].innerText != name) {

					// Get the modal
					var modal = document.getElementById("myModal");

					var modalContents = document.getElementById("modalContents");

					// Get the <span> element that closes the modal
					var span = document.getElementsByClassName("close")[0];

					// When the user clicks on <span> (x), close the modal
					span.onclick = function() {
					  modal.style.display = "none";
					}

					// When the user clicks anywhere outside of the modal, close it
					window.onclick = function(event) {
					  if (event.target == modal) {
					    modal.style.display = "none";
					  }
					}

					 modalContents.innerHTML = "Can not update other admins !";

					 modal.style.display = "block";

					return;
				}

			}

		}

		if (howManyChecked > 1) {

			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}

			 modalContents.innerHTML = "Please select only one user to update !";

			 modal.style.display = "block";

		} else if (howManyChecked == 0) {

			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			  }
			}

			 modalContents.innerHTML = "Please select a user to update !";

			 modal.style.display = "block";

		} else {
			console.log("do update of " + checkboxes[whichOneIsChecked].id);

			window.location = "update?id=" + checkboxes[whichOneIsChecked].id;

		}

	}

	function clearLabels(event) {

		inputIdLabel = document.getElementById("userId");
		inputNameLabel = document.getElementById("userName");
		inputCategoryLabel = document.getElementById("userCategory");
		inputSexLabel = document.getElementById("userSex");
		inputAddressLabel = document.getElementById("userAddress");
		inputEmailIdLabel = document.getElementById("userEmailId");

		inputIdLabel.classList.remove('red');
		inputIdLabel.classList.add('olive');

		inputNameLabel.classList.remove('red');
		inputNameLabel.classList.add('olive');

		inputCategoryLabel.classList.remove('red');
		inputCategoryLabel.classList.add('olive');

		inputSexLabel.classList.remove('red');
		inputSexLabel.classList.add('olive');

		inputAddressLabel.classList.remove('red');
		inputAddressLabel.classList.add('olive');

		inputEmailIdLabel.classList.remove('red');
		inputEmailIdLabel.classList.add('olive');

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

	function showTable(){

	}

	function clearTable() {
		var input, filter, found, table, tr, td, i, j;
		input = document.getElementById("myInput");
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");
		document.getElementById('tableListHeaderId').style.display="";
		document.getElementById('tableListHeaderId').innerHTML = "Table List";
		document.getElementById('updateBtn').style.display="";
		document.getElementById('deleteBtn').style.display="";
		document.getElementById('detailsBtn').style.display="";
		document.getElementById('myTable').style.display = "";
		document.getElementById('adminControls').style.display = "";

		for (i = 0; i < tr.length; i++) {
			tr[i].style.display = "";
		}

		document.getElementById("searchId").value = "";
		document.getElementById("searchName").value = "";
		document.getElementById("searchCategory").value = "";
		document.getElementById("searchSex").value = "";
		document.getElementById("searchAddress").value = "";
		document.getElementById("searchEmailId").value = "";

	}


	function showRowByIds(ids) {

		console.log("In ids " + ids);

		var table = document.getElementById("myTable");
		var tr = table.getElementsByTagName("tr");

		for (i = 0; i < tr.length; i++) {

			if (ids.includes(i) == true) {
				tr[i].style.display = "";

			} else {
				if (tr[i].id != 'tableHeader') {
					tr[i].style.display = "none";
				}
			}
		}
	}

	function showRowById(id) {

		var table = document.getElementById("myTable");
		var tr = table.getElementsByTagName("tr");

		for (i = 0; i < tr.length; i++) {

			if (i == id) {
				tr[i].style.display = "";

			} else {
				if (tr[i].id != 'tableHeader') {
					tr[i].style.display = "none";
				}
			}
		}
	}

	function searchTable() {
		var inputId, inputName, inputCategory, inputSex, inputAddress, inputEmailId, filterId, filterName, filterCategory, filterSex, filterAddress, filterEmailId, found, table, tr, td, i, j;
		//turn on table
		document.getElementById('tableListHeaderId').style.display = "";
		document.getElementById('tableListHeaderId').innerHTML = "Table List";
		document.getElementById('updateBtn').style.display="";
		document.getElementById('deleteBtn').style.display="";
		document.getElementById('detailsBtn').style.display="";

		document.getElementById('tableListHeaderId').style.display="";
		document.getElementById('tableListHeaderId').innerHTML = "Table List";
		document.getElementById('updateBtn').style.display="";
		document.getElementById('deleteBtn').style.display="";
		document.getElementById('detailsBtn').style.display="";
		document.getElementById('myTable').style.display = "";
		document.getElementById('adminControls').style.display = "";

		inputId = document.getElementById("searchId");
		inputName = document.getElementById("searchName");
		inputCategory = document.getElementById("searchCategory");
		inputSex = document.getElementById("searchSex");
		inputAddress = document.getElementById("searchAddress");
		inputEmailId = document.getElementById("searchEmailId");
		inputIdLabel = document.getElementById("userId");

		inputNameLabel = document.getElementById("userName");
		inputCategoryLabel = document.getElementById("userCategory");
		inputSexLabel = document.getElementById("userSex");
		inputAddressLabel = document.getElementById("userAddress");
		inputEmailIdLabel = document.getElementById("userEmailId");

		filterId = inputId.value.toUpperCase();
		filterName = inputName.value.toUpperCase();
		filterCategory = inputCategory.value.toUpperCase();
		filterSex = inputSex.value.toUpperCase();
		filterAddress = inputAddress.value.toUpperCase();
		filterEmailId = inputEmailId.value.toUpperCase();

		if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0) {
			console.log("No input");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			clearTable();
			return;
		}

		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");

		var foundIdSex = 0;
		var foundIdCategory = 0;
		var foundSexCategory = new Array();
		var foundUseridSexCategory = 0;


		for (i = 0; i < tr.length; i++) {

			td = tr[i].getElementsByTagName("td");

			for (j = 1; j < td.length; j++) {

				if ((td[1].innerHTML.toUpperCase() == filterId)
						&& (td[4].innerText.toUpperCase() == filterSex)) {

					foundIdSex = i;
				}

				if ((td[1].innerHTML.toUpperCase() == filterId)
						&& (td[3].innerText.toUpperCase() == filterCategory)) {
					foundIdCategory = i;
				}

				if ((td[4].innerText.toUpperCase() == filterSex)
						&& (td[3].innerText.toUpperCase() == filterCategory)) {
					foundSexCategory.push(i);
				}
				if ((td[1].innerHTML.toUpperCase() == filterId)
						&& (td[4].innerText.toUpperCase() == filterSex)
						&& (td[3].innerText.toUpperCase() == filterCategory)) {
					foundUseridSexCategory  = i;
				}



				if ((td[1].innerHTML.toUpperCase() == filterId)) {

					found = true;
				}
				if (td[2].innerText.toUpperCase() == filterName) {

					found = true;
				}
				if (td[3].innerText.toUpperCase() == filterCategory) {

					found = true;
				}
				if (td[4].innerText.toUpperCase() == filterSex) {

					found = true;
				}
				if (td[5].innerText.toUpperCase() == filterAddress) {

					found = true;
				}
				if (td[6].innerText.toUpperCase() == filterEmailId) {

					found = true;
				}

			}

			if (foundIdSex != 0) {
				break;
			}

			if (found) {
				tr[i].style.display = "";
				found = false;

			} else {
				if (tr[i].id != 'tableHeader') {
					tr[i].style.display = "none";
				}
			}

		}


		if(foundSexCategory.length > 0){
			showRowByIds(foundSexCategory);
		}

		if (foundIdSex != 0) {
			showRowById(foundIdSex);
		}

		if (foundIdCategory != 0) {
			showRowById(foundIdCategory);
		}


		if (foundUseridSexCategory != 0) {
			showRowById(foundUseridSexCategory);
		}




		if (found == undefined && foundIdSex == 0 && foundIdCategory == 0) {
			document.getElementById('tableListHeaderId').innerHTML = "Table List No Records Found !";
			document.getElementById('myTable').style.display = "none";
			document.getElementById('adminControls').style.display = "none";

		}
	}

	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
</head>
<style>


/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */

  -webkit-animation: fadein 2s; /* Safari, Chrome and Opera > 12.1 */
       -moz-animation: fadein 2s; /* Firefox < 16 */
        -ms-animation: fadein 2s; /* Internet Explorer */
         -o-animation: fadein 2s; /* Opera < 12.1 */
            animation: fadein 2s;
}


@keyframes fadein {
    from { opacity: 0; }
    to   { opacity: 1; }
}

/* Firefox < 16 */
@-moz-keyframes fadein {
    from { opacity: 0; }
    to   { opacity: 1; }
}

/* Safari, Chrome and Opera > 12.1 */
@-webkit-keyframes fadein {
    from { opacity: 0; }
    to   { opacity: 1; }
}

/* Internet Explorer */
@-ms-keyframes fadein {
    from { opacity: 0; }
    to   { opacity: 1; }
}

/* Opera < 12.1 */
@-o-keyframes fadein {
    from { opacity: 0; }
    to   { opacity: 1; }
}



/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
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
	box-shadow: inset 0 0 20px rgba(255, 255, 255, .5), 0 0 20px
		rgba(255, 255, 255, .2);
	outline-color: rgba(255, 255, 255, 0);
	outline-offset: 15px;
	text-shadow: 1px 1px 2px #427388;
}

thead, tbody {
	display: block;
}

td {
	width: 230px;
	word-break: break-all;
}

tbody {
	height: 150px; /* Just for the demo          */
	overflow-y: auto; /* Trigger vertical scroll    */
	overflow-x: auto; /* Hide the horizontal scroll */
}

@media only screen and (max-width: 760px) , ( min-device-width : 768px)
	and (max-device-width: 1024px) {
	/* Force table to not be like tables anymore */
	table, thead, tbody, td, tr {
		display: block;
	}
	th {
		display: none;
	}
	/* Hide table headers (but not display: none;, for accessibility) */
	thead tr {
		position: absolute;
		top: -9999px;
		left: -9999px;
	}

	#adminControls{
	position:relative;
	left:29%;
	}

	tr {
		border: 1px solid #ccc;
	}
	td {
		/* Behave  like a "row" */
		border: none;
		border-bottom: 1px solid #eee;

		position: relative;
		padding-left: 40%;
		padding-right:40%;

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
	td:nth-of-type(1):before {
		content: "Select User";
	}
	td:nth-of-type(2):before {
		content: "User ID";
	}
	td:nth-of-type(3):before {
		content: "Name";
	}
	td:nth-of-type(4):before {
		content: "Category";
	}
	td:nth-of-type(5):before {
		content: "Sex";
	}
	td:nth-of-type(6):before {
		content: "Address";
	}
	td:nth-of-type(7):before {
		content: "EmailId";
	}
	td:nth-of-type(8):before {
		content: "Enable/Disable User";
	}

}
</style>

<body onload="disableBackButton()">

	<!-- Header -->
	<div
		style="background-color: #333; opacity: 0.8; position: fixed; left: 0; overflow: hidden; white-space: nowrap; top: 0; width: 100%">
		<h3 style="float: left; color: gold; position: absolute; left: 0">
			<s:if test="#session.loggedInUserType != null">

			</s:if>
		</h3>
		<h3 style="float: left; color: gold; position: relative; left: 43%;">
		<s:if test="#session.loggedInUserType != 'User'">
			<s:text name="global.welcomelistscreen"></s:text>
			</s:if>
			<br>
			<s:text name="global.welcomemessage"></s:text>

			<s:if test="#session.loggedInUser != null">
				<s:property value="#session.loggedInUser" />
			</s:if>
		</h3>

		<a type="button" class="btn-5" href="logout"
			style="text-decoration: none; position: relative; float: right; background: red; padding: 0.7em 2em; color: #fff; border: 0; margin: 10px; text-decoration: none; display: inline-block;">
			<i class="fa fa-sign-out fa-lg" aria-hidden="true"></i> <s:text
				name="global.logout"></s:text>
		</a>
	</div>

	<div class="clearfix"></div>


	<div class="content clearfix">
		<s:if test="#session.loggedInUserType != null">
			<s:if test="#session.loggedInUserType == 'Admin' ">
				<h3 style="color: gold; position: relative; left: 45%; top: 20%">Search
					Criteria</h3>
				<div class="ui form" style="position: relative; left: 30%;">
					<div class="inline fields">
						<div class="field">
							<label class="ui olive label" id="userId" style="width:70px"><s:text
									name="global.searchid"></s:text></label> <input type="text"
								placeholder="User ID" onmouseover="clearLabels(event)"
								id="searchId">
						</div>
						<div class="field">
							<label class="ui olive label" id="userCategory" style="width:70px"><s:text
									name="global.searchcategory"></s:text></label> <select
								class="ui search dropdown" id="searchCategory" style="position:fixed;width:190px;">
								<option value="">---</option>
								<option value="admin"><s:text
										name="global.searchcategory.admin"></s:text></option>
								<option value="user"><s:text
										name="global.searchcategory.user"></s:text></option>
							</select>
						</div>
					</div>
					<div class="inline fields">
						<div class="field">
							<label class="ui olive label" id="userName" style="width:70px"><s:text
									name="global.searchname"></s:text></label> <input type="text"
								placeholder="Name" id="searchName"
								onmouseover="clearLabels(event)">
						</div>
						<div class="field">
							<label class="ui olive label" id="userAddress" style="width:70px"><s:text
									name="global.searchaddress"></s:text></label> <input type="text"
								placeholder="Address" onmouseover="clearLabels(event)"
								id="searchAddress">
						</div>
					</div>
					<div class="inline fields">
						<div class="field" style="position: relative; left: 5px;">
							<label class="ui olive label" id="userSex" style="width:70px"><s:text
									name="global.searchsex"></s:text></label> <select
								class="ui search dropdown" id="searchSex" style="position:fixed;width:188px;">
								<option value="">---</option>
								<option value="male"><s:text
										name="global.searchsex.male"></s:text></option>
								<option value="female"><s:text
										name="global.searchsex.female"></s:text></option>
							</select>
						</div>
						<div class="field" style="position: relative; left: 195px;">
							<label class="ui olive label" id="userEmailId" style="width:70px"><s:text
									name="global.searchemail"></s:text></label> <input type="text"
								placeholder="Email" onmouseover="clearLabels(event)"
								id="searchEmailId">
						</div>
					</div>
					<div class="ui" style="position: relative; left: 170px;">
						<button class="ui inverted primary button" onclick="searchTable()"
							>
							<i class="fa fa-search fa-lg" aria-hidden="true"></i>
							<s:text name="global.search"></s:text>
						</button>

						<button class="ui inverted red button"
							onclick="clearTable();clearLabels(event)"
							style="position: relative; left: 10px;">
							<i class="fa fa-trash fa-lg" aria-hidden="true"></i>
							<s:text name="global.clear1"></s:text>
						</button>
					</div>

				</div>
			</s:if>
		</s:if>

		<s:if test="#session.loggedInUserType == 'User' ">
		<h3 style="color: gold; position: relative; left: 46%; top: 20%"
			id="tableListHeaderId">Table List</h3>
		<table id="myTable">
		</s:if>
		<s:else>
		<h3 style="display:none;color: gold; position: relative; left: 46%; top: 20%"
			id="tableListHeaderId">Table List</h3>
		<table id="myTable" style="display:none">
		</s:else>

<thead>
		<s:if test="#session.loggedInUserType == 'User' ">
		<tr id='tableHeader' style="">
					<th><input type="checkbox" onclick="toggle(this);"
						name="allUsers"  hidden/></th>
		</s:if>
		<s:else>
		<tr id='tableHeader' style="">
					<th><input type="checkbox" onclick="toggle(this);"
						name="allUsers" /></th>
		</s:else>

					<th><s:text name="global.searchid"></s:text></th>
					<th><s:text name="global.searchname"></s:text></th>
					<th><s:text name="global.searchcategory"></s:text></th>
					<th><s:text name="global.searchsex"></s:text></th>
					<th><s:text name="global.searchaddress"></s:text></th>
					<th><s:text name="global.searchemail"></s:text></th>

					<s:if test="#session.loggedInUserType != null">
						<s:if test="#session.loggedInUserType == 'Admin' ">
							<th><s:text name="global.searchid"></s:text></th>
						</s:if>
					</s:if>

				</tr>
</thead>
	<tbody>
				<s:iterator var="i" step="1" value="users">

					<tr>
						<td><s:if test="#session.loggedInUserType != null">
								<s:if test="#session.loggedInUserType == 'User' ">
									<s:if test="isDisabled == 'true' ">
										<input type="checkbox" disabled checked
											id="<s:property value="userid" />" />
									</s:if>
									<s:else>
										<input type="checkbox" checked hidden id="<s:property value="userid" />" />
									</s:else>
								</s:if>
								<s:else>
									<s:if test="isDisabled == 'true' ">

										<input type="checkbox" disabled onchange='handleChange(this);'
											onclick='handleChange(this);' id="<s:property value="userid" />" />
									</s:if>
									<s:else>
										<input type="checkbox" onchange='handleChange(this);'
											onclick='handleChange(this);' id="<s:property value="userid" />" />
									</s:else>
								</s:else>
							</s:if></td>
						<td data-th="Movie Title"><s:property value="userName" /></td>
						<td data-th="Movie Title"><s:property value="userDataBean.name" /></td>
						<td data-th="Genre" id="category"><s:property
								value="userDataBean.category" /></td>
						<td data-th="Year"><s:property value="userDataBean.sex" /></td>
						<td data-th="Gross"><s:property value="userDataBean.address" /></td>
						<td data-th="Gross"><s:property value="userDataBean.emailId" /></td>

						<s:if test="#session.loggedInUserType != null">
							<s:if test="#session.loggedInUserType == 'Admin' ">
								<td data-th="Gross"><s:if test="userDataBean.isDisabled == 'true' ">
										<button class="ui green button"
											name="<s:property value="userid" />" id="enableBtn"
											onclick="enableUser(this)"
											style="position: relative; left: 30px;">
											<i class="fa fa-toggle-on fa-lg" aria-hidden="true"></i>
											<s:text name="global.enable"></s:text>
										</button>
									</s:if> <s:else>
										<button class="ui red button" name="<s:property value="userid" />"
											id="disableBtn" onclick="disableUser(this)"
											style="position: relative; left: 30px;">
											<i class="fa fa-ban fa-lg" aria-hidden="true"></i>
											<s:text name="global.disable"></s:text>
										</button>
									</s:else></td>

							</s:if>
						</s:if>

					</tr>
				</s:iterator>
			</tbody>
		</table>

<div class="ui buttons" id="adminControls"
					style="position: fixed; left: 37%;top:85%;">
<s:if test="#session.loggedInUserType == 'User' ">
</s:if>

<s:else>
<a class="ui green button" href="add"
						style="position:relative;left: 10px;"> <i
						class="fa fa-plus fa-lg" aria-hidden="true"></i> <s:text
							name="global.register"></s:text></a>
</s:else>

		<s:if test="#session.loggedInUserType != null">
			<s:if test="#session.loggedInUserType == 'Admin' ">
					<button class="ui violet button" onclick="updateHref()"
						name="<s:property value="#session.loggedInUser"/>" id="updateBtn"
						style="position: relative; left: 20px;display:none">
						<i class="fa fa-edit fa-lg" aria-hidden="true"></i>
						<s:text name="global.update"></s:text>
					</button>

					<button class="ui red button" onclick="deleteHref()" id="deleteBtn"
						style="position: relative; left: 30px;display:none">
						<i class="fa fa-trash fa-lg" aria-hidden="true"></i>
						<s:text name="global.delete"></s:text>
					</button>

					<button class="ui blue button" onclick="detailsHref()"
						id="detailsBtn" style="position: relative; left: 40px;display:none">
						<i class="fa fa-eye fa-lg" aria-hidden="true"></i>
						<s:text name="global.details"></s:text>
					</button>

			</s:if>
		</s:if>
		</div>
		<s:if test="#session.loggedInUserType != null">
			<s:if test="#session.loggedInUserType == 'User' ">
				<div class="ui buttons" id="userControls"
					style="position: relative; left: 43%;">
					<button class="ui violet button" onclick="updateHref()"
						name="<s:property value="#session.loggedInUser"/>" id="updateBtn"
						style="position: relative; left: 20px;">
						<i class="fa fa-edit fa-lg" aria-hidden="true"></i>
						<s:text name="global.update"></s:text>
					</button>

					<button class="ui blue button" onclick="detailsHref()"
						id="detailsBtn" style="position: relative; left: 30px;">
						<i class="fa fa-eye fa-lg" aria-hidden="true"></i>
						<s:text name="global.details"></s:text>
					</button>
				</div>
			</s:if>
		</s:if>

	</div>

	<footer class="footer" style="border: none">
		<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <center>
    <h3 id="modalContents">Some text in the Modal..</h3>
  </center>
  </div>

</div>

		<p>&copy; 2019 Unikaihatsu Software Pvt Ltd.</p>
	</footer>

</body>
</html>