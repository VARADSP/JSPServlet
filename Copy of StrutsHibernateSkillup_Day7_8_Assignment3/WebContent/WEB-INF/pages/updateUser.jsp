<!--
 JSP page updateUser displays user update form
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
<title>User Data Update User</title>
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
	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);

	function togglePassword() {
		var x = document.getElementById("searchPassword");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}

	function clearFields(event) {

		inputId = document.getElementById("searchId");
		inputPassword = document.getElementById("searchPassword");
		inputName = document.getElementById("searchName");
		inputCategory = document.getElementById("searchCategory1");
		inputSex = document.getElementById("searchSex1");
		inputAddress = document.getElementById("searchAddress");
		inputEmailId = document.getElementById("searchEmailId");

		inputId.value = "";
		inputPassword.value = "";
		inputName.value = "";
		inputCategory.innerHTML = "---";
		inputSex.innerHTML = "---";
		inputAddress.value = "";
		inputEmailId.value = "";

		clearLabels();

		event.preventDefault();
	}

	function clearLabels(event) {

		inputIdLabel = document.getElementById("userId");
		inputPasswordLabel = document.getElementById("userPassword");
		inputNameLabel = document.getElementById("userName");
		inputCategoryLabel = document.getElementById("userCategory");
		inputSexLabel = document.getElementById("userSex");
		inputAddressLabel = document.getElementById("userAddress");
		inputEmailIdLabel = document.getElementById("userEmailId");

		inputIdLabel.classList.remove('red');
		inputIdLabel.classList.add('olive');

		inputPasswordLabel.classList.remove('red');
		inputPasswordLabel.classList.add('olive');

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

	function validateForm(event) {
		event.preventDefault();
		var inputId, inputName, inputCategory, inputSex, inputAddress, inputEmailId, inputPassword, filterId, filterName, filterCategory, filterSex, filterAddress, filterEmailId, filterPassword, found, table, tr, td, i, j;

		inputId = document.getElementById("searchId");
		inputPassword = document.getElementById("searchPassword");

		inputIdLabel = document.getElementById("userId");
		inputPasswordLabel = document.getElementById("userPassword");
		inputNameLabel = document.getElementById("userName");
		inputCategoryLabel = document.getElementById("userCategory");
		inputSexLabel = document.getElementById("userSex");
		inputAddressLabel = document.getElementById("userAddress");
		inputEmailIdLabel = document.getElementById("userEmailId");

		inputName = document.getElementById("searchName");
		inputCategory = document.getElementById("searchCategory");
		inputSex = document.getElementById("searchSex");
		inputAddress = document.getElementById("searchAddress");
		inputEmailId = document.getElementById("searchEmailId");

		filterId = inputId.value.toUpperCase();
		filterPassword = inputPassword.value.toUpperCase();
		filterName = inputName.value.toUpperCase();
		filterCategory = inputCategory.value.toUpperCase();
		filterSex = inputSex.value.toUpperCase();
		filterAddress = inputAddress.value.toUpperCase();
		filterEmailId = inputEmailId.value.toUpperCase();

		if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("1");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

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

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterName.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

			console.log("2");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

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

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";
		} else if (filterId.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

			console.log("3");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterId.length == 0 && filterCategory.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("4");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0) {

			console.log("5");

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

			inputId.placeholder = "Please Enter User Id";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		}

		else if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

			console.log("6");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterPassword.length == 0) {

			console.log("7");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";

		} else if (filterId.length == 0 && filterName.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

			console.log("8");

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		}

		else if (filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("9");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputPassword.placeholder = "Please Enter Password";

			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterName.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("10");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

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

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterName.length == 0 && filterCategory.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("11");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		}

		if (filterName.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			console.log("12");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";

			inputEmailId.placeholder = "Please Enter EmailId";

		}
		if (filterName.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterPassword.length == 0) {

			console.log("13");

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";

		} else if (filterName.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0) {

			console.log("14");

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

			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";
			inputEmailId.placeholder = "Please Enter EmailId";

		} else if (filterName.length == 0) {

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputName.placeholder = "Please Enter Name";
		} else if (filterCategory.length == 0) {

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');
		} else if (filterSex.length == 0) {

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');
		} else if (filterAddress.length == 0) {

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');
		} else if (filterPassword.length == 0) {

			inputPassword.placeholder = "Please Enter Password";
			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

		} else if (filterId.length == 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length != 0
				&& filterPassword.length == 0) {

			inputId.placeholder = "Please Enter User Id";
			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";

			inputIdLabel.classList.remove('olive');
			inputIdLabel.classList.add('red');

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

		} else if (filterId.length != 0 && filterName.length == 0
				&& filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

			inputPassword.placeholder = "Please Enter Password";
			inputName.placeholder = "Please Enter Name";
			inputAddress.placeholder = "Please Enter Address";

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputNameLabel.classList.remove('olive');
			inputNameLabel.classList.add('red');

			inputCategoryLabel.classList.remove('olive');
			inputCategoryLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

		}

		else {

			if (filterId.length == 0 || filterName.length == 0
					|| filterCategory.length == 0 || filterSex.length == 0
					|| filterAddress.length == 0 || filterEmailId.length == 0
					|| filterPassword.length == 0) {

				return false;
			}

			var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			if (reg.test(inputEmailId.value) == false) {
				console.log("Not valid mail");
				inputEmailIdLabel.classList.remove('olive');
				inputEmailIdLabel.classList.add('red');

				inputEmailId.value = "Please enter valid email";

				return false;
			}


			// Get the modal
			var modal = document.getElementById("myModal");

			var modalContents = document.getElementById("modalContents");

			// Get the <span> element that closes the modal
			var span = document.getElementsByClassName("close")[0];



			 modalContents.innerHTML = "User details updated successfully !";

			 modal.style.display = "block";

			console.log("Success");

			// When the user clicks on <span> (x), close the modal
			span.onclick = function() {
			  modal.style.display = "none";
			  document.userRegistrationForm.submit();// fire submit event
			}

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			  if (event.target == modal) {
			    modal.style.display = "none";
			    document.userRegistrationForm.submit();// fire submit event
			  }
			}


		}

	}
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

.red::placeholder {
	color: red;
	font-size: 1.2em;
	font-style: italic;
}
</style>

<body onload="disableBackButton()">

	<!-- Header -->
	<div
		style="background-color: #333; opacity: 0.8; position: fixed; left: 0; overflow: hidden; white-space: nowrap; top: 0; width: 100%">
		<h3 style="float: left; color: gold; position: absolute; left: 0">
			<s:if test="#session.loggedInUserType != null">
				<s:text name="global.useraccesstype"></s:text>
				<s:property value="#session.loggedInUserType" />
			</s:if>
		</h3>
		<h3 style="float: left; color: gold; position: relative; left: 43%;">
			<s:text name="global.welcomelistscreen"></s:text>
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

			<h3 style="color: gold; position: relative; left: 15%; top: 20%">
				<s:text name="global.update"></s:text>
			</h3>
			<s:form action="updateUser" name="userRegistrationForm" method="post"
				onmouseover="clearLabels(event)" cssClass="ui form"
				style="position:relative;left:15%;">
					<div class="inline fields">
					<div class="field">
						<label class="ui olive label" id="userId"><s:text
								name="global.searchid"></s:text></label> <input type="hidden"
							name="loginBean.userName"
							value="<s:property value="loginBean.userName" />" /> <input
							type="text" placeholder="User ID"
							value="<s:property value="loginBean.userName" />"
							name="loginBean.userName" onmouseover="clearLabels(event)"
							id="searchId">
					</div>
					<div class="field">
						<label class="ui olive label" id="userPassword"><s:property
								value="getText('global.password')" /></label> <input type="password"
							placeholder="Password" onmouseleave="togglePassword()"
							onclick="togglePassword()" name="loginBean.password"
							value="<s:property value="loginBean.password" />"
							onmouseover="clearLabels(event)" id="searchPassword">
					</div>
					<div class="field">
						<label class="ui olive label" id="userCategory"><s:text
								name="global.searchcategory"></s:text></label> <select
							class="ui search dropdown" name="loginBean.userDataBean.category" style="width:200px"
							id="searchCategory">
							<option value="" id="searchCategory1">---</option>
							<option value="Admin"
								<s:if test= 'loginBean.userDataBean.category == "Admin"'>selected</s:if>><s:text
									name="global.searchcategory.admin"></s:text></option>
							<option value="User"
								<s:if test= 'loginBean.userDataBean.category == "User"'>selected</s:if>><s:text
									name="global.searchcategory.user"></s:text></option>
						</select>
					</div>
				</div>
				<div class="inline fields">
					<div class="field">
						<label class="ui olive label" id="userName"><s:text
								name="global.searchname"></s:text></label> <input type="text"
							placeholder="Name" name="loginBean.userDataBean.name" style="width:200px"
							value="<s:property value="loginBean.userDataBean.name" />" id="searchName">
					</div>
					<div class="field">
						<label class="ui olive label" id="userAddress"><s:text
								name="global.searchaddress"></s:text></label> <input type="text"
							placeholder="Address" name="loginBean.userDataBean.address" style="width:200px"
							value="<s:property value="loginBean.userDataBean.address" />"
							id="searchAddress">
					</div>
				</div>
				<div class="inline fields">
					<div class="field" style="position: relative; left: 20px;">
						<label class="ui olive label" id="userSex"><s:text
								name="global.searchsex"></s:text></label> <select
							class="ui search dropdown" name="loginBean.userDataBean.sex" id="searchSex" style="width:200px">
							<option value="" id="searchSex1">---</option>
							<option value="Male"
								<s:if test= 'loginBean.userDataBean.sex == "Male"'>selected</s:if>><s:text
									name="global.searchsex.male"></s:text></option>
							<option value="Female"
								<s:if test= 'loginBean.userDataBean.sex == "Female"'>selected</s:if>><s:text
									name="global.searchsex.female"></s:text></option>
						</select>
					</div>
					<div class="field" style="position: relative; left: 30px;">
						<label class="ui olive label" id="userEmailId"><s:text
								name="global.searchemail"></s:text></label> <input type="email" style="width:200px"
							placeholder="Email" name="loginBean.userDataBean.emailId"
							value="<s:property value="loginBean.userDataBean.emailId" />"
							id="searchEmailId">
					</div>
				</div>

				<div class="ui">
					<button class="ui inverted primary button" type="submit"
						onclick="return validateForm(event);"
						style="position: relative; left: 30px;">
						<i class="fa fa-refresh fa-lg" aria-hidden="true"></i>
						<s:text name="global.update"></s:text>
					</button>

					<s:url var="backURL" action="showUser">
					</s:url>

					<button class="ui inverted red button"
						onclick="return clearFields(event)"
						style="position: relative; left: 50px;">
						<i class="fa fa-trash fa-lg" aria-hidden="true"></i>
						<s:text name="global.clear1"></s:text>
					</button>

					<a class="ui inverted green button"
						style="position: relative; left: 60px;"
						href="<s:property value="#backURL"/>"> <i
						class="fa fa-arrow-left fa-lg" aria-hidden="true"></i> <s:text
							name="global.clear"></s:text>
					</a>


				</div>

			</s:form>
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
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"
		integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
		crossorigin="anonymous"></script>
	<!-- Semantic UI -->
	<script
		src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
</body>
</html>