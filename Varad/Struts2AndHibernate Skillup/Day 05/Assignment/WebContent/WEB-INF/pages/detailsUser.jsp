<!--
 JSP page detailsUser.jsp page displays user information
@author:varad paralikar
Created Date: 2019/9/5
-->

<%@ page contentType="text/html;charset=UTF-8"%>
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

		console.log("in registration");
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
			console.log("No input");

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

		} else if (filterName.length == 0 && filterCategory.length == 0
				&& filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

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

		} else if (filterCategory.length == 0 && filterSex.length == 0
				&& filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {

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

		} else if (filterSex.length == 0 && filterAddress.length == 0
				&& filterEmailId.length == 0 && filterPassword.length == 0) {

			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputSexLabel.classList.remove('olive');
			inputSexLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

		} else if (filterAddress.length == 0 && filterEmailId.length == 0
				&& filterPassword.length == 0) {
			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputAddressLabel.classList.remove('olive');
			inputAddressLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

		} else if (filterEmailId.length == 0 && filterPassword.length == 0) {
			inputPasswordLabel.classList.remove('olive');
			inputPasswordLabel.classList.add('red');

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');

		} else if (filterEmailId.length == 0) {

			inputEmailIdLabel.classList.remove('olive');
			inputEmailIdLabel.classList.add('red');
		}

		else {
			document.userRegistrationForm.submit();// fire submit event
		}

	}
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
			<h3 style="color: gold; position: relative; left: 35%; top: 20%">
				<s:text name="global.details"></s:text>
			</h3>
			<s:form action="updateUser" name="userRegistrationForm" method="post"
				onmouseover="clearLabels(event)" cssClass="ui form"
				style="position:relative;left:15%;">
				<div class="inline fields">
					<div class="field">
						<label class="ui olive label" id="userId"><s:text
								name="global.searchid"></s:text></label> <input type="hidden"
							name="userDataBean.id"
							value="<s:property value="userDataBean.id" />" /> <input
							type="text" placeholder="User ID"
							value="<s:property value="userDataBean.userId" />"
							name="userDataBean.userId" onmouseover="clearLabels(event)"
							id="searchId">
					</div>
					<div class="field">
						<label class="ui olive label" id="userPassword"><s:property
								value="getText('global.password')" /></label> <input type="password"
							placeholder="Password" onmouseleave="togglePassword()"
							onclick="togglePassword()" name="userDataBean.password"
							value="<s:property value="userDataBean.password" />"
							onmouseover="clearLabels(event)" id="searchPassword">
					</div>
					<div class="field">
						<label class="ui olive label" id="userCategory"><s:text
								name="global.searchcategory"></s:text></label> <select
							class="ui search dropdown" name="userDataBean.category" style="width:200px"
							id="searchCategory">
							<option value="" id="searchCategory1">---</option>
							<option value="Admin"
								<s:if test= 'userDataBean.category == "Admin"'>selected</s:if>><s:text
									name="global.searchcategory.admin"></s:text></option>
							<option value="User"
								<s:if test= 'userDataBean.category == "User"'>selected</s:if>><s:text
									name="global.searchcategory.user"></s:text></option>
						</select>
					</div>
				</div>
				<div class="inline fields">
					<div class="field">
						<label class="ui olive label" id="userName"><s:text
								name="global.searchname"></s:text></label> <input type="text"
							placeholder="Name" name="userDataBean.name" style="width:200px"
							value="<s:property value="userDataBean.name" />" id="searchName">
					</div>
					<div class="field">
						<label class="ui olive label" id="userAddress"><s:text
								name="global.searchaddress"></s:text></label> <input type="text"
							placeholder="Address" name="userDataBean.address" style="width:200px"
							value="<s:property value="userDataBean.address" />"
							id="searchAddress">
					</div>
				</div>
				<div class="inline fields">
					<div class="field" style="position: relative; left: 20px;">
						<label class="ui olive label" id="userSex"><s:text
								name="global.searchsex"></s:text></label> <select
							class="ui search dropdown" name="userDataBean.sex" id="searchSex" style="width:200px">
							<option value="" id="searchSex1">---</option>
							<option value="Male"
								<s:if test= 'userDataBean.sex == "Male"'>selected</s:if>><s:text
									name="global.searchsex.male"></s:text></option>
							<option value="Female"
								<s:if test= 'userDataBean.sex == "Female"'>selected</s:if>><s:text
									name="global.searchsex.female"></s:text></option>
						</select>
					</div>
					<div class="field" style="position: relative; left: 30px;">
						<label class="ui olive label" id="userEmailId"><s:text
								name="global.searchemail"></s:text></label> <input type="email" style="width:200px"
							placeholder="Email" name="userDataBean.emailId"
							value="<s:property value="userDataBean.emailId" />"
							id="searchEmailId">
					</div>
				</div>
				<div class="ui">

					<s:url var="backURL" action="showUser">
					</s:url>

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