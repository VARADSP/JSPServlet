<!--
JSP page Login is used to login the user
@author:varad paralikar
Created Date: 2019/8/19
-->
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<html lang="en">
<head>
	<title>Login Form</title>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">


<script type="text/javascript">

/*
 * function removeTest is used to remove inner text of test div
 	return type : void
 */
function removeTest(){
	var test = document.getElementById('test');
	test.innerHTML = "";

}
/*
 * function validate is used to validate login form
 	return type : void
 */
function validate(event){

	event.preventDefault();

 var username = document.getElementById('username');
 var password = document.getElementById('password');


 if(username.value.length == 0 && password.value.length == 0){
	 username.placeholder = "Please enter username";
	 password.placeholder = "Please enter password";
	 username.classList.add("Red");
	 password.classList.add("Red");


 }
 else if(username.value.length == 0){
	 username.placeholder = "Please enter username";
	 username.classList.add("Red");
	 password.placeholder = "Password";
	 password.classList.remove("Red");

 }
 else if(password.value.length == 0){
	 username.placeholder = "Username";
	 username.classList.remove("Red");
	 password.placeholder = "Please enter password";
	 password.classList.add("Red");
 }
 else{
	 document.getElementById('loginForm').submit();
 }

}


</script>
<!-- Javascript for login form validation -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>



<style>
.Red::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
  color: red;
  opacity: 1; /* Firefox */
}
</style>
</head>
<!-- Body tag -->
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form id="loginForm" class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="Login" method="post" onSubmit="return validate(event);">
					<span class="login100-form-title">
						Login
					</span>
				<!-- Login header -->


				<c:catch var ="catchException">

<!-- JSTL tags to check if user is already logged in -->
				<c:choose>

					<c:when test="${sessionScope.authentication == 'authenticated' && sessionScope.authentication != null}">
				<jsp:forward page = "error/error.jsp"/>
        		 <br />
    			</c:when>

   				 <c:when test="${sessionScope.authentication == 'notAuthenticated' && sessionScope.authentication != null}">
        	<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input id="username" class="Red input100" type="text" onchange="removeTest()" onclick="removeTest()" name="username" placeholder="Invalid Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input id="password" class="Red input100" type="password" name="password" placeholder="Invalid Password">
						<span class="focus-input100"></span>
					</div>

        		<c:remove var="authentication"/>
   			     <br />
    			</c:when>


    		<c:otherwise>
    			<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input id="username" class="input100" type="text" onchange="removeTest()" onclick="removeTest()" name="username" placeholder="Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input id="password" class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>


    		</c:otherwise>

				</c:choose>
   			</c:catch>


					<div class="text-right p-t-13 p-b-23">

					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn" onclick="validate(event)">
							Login
						</button>
						<!-- Login button on submit -->
					</div>


					<div id="test" class="flex-col-c p-t-170 p-b-40">


					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>