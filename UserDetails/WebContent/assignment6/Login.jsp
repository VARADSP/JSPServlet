
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

function removeTest(){
	var test = document.getElementById('test');
	test.innerHTML = "";

}


</script>
</head>

<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178" action="Login" method="post">
					<span class="login100-form-title">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input class="input100" type="text" onchange="removeTest()" onclick="removeTest()" name="username" placeholder="Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">



					</div>

					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							Login
						</button>
					</div>


					<div id="test" class="flex-col-c p-t-170 p-b-40">

 		<c:catch var ="catchException">


				<c:choose>
					<c:when test="${sessionScope.authentication == 'authenticated' && sessionScope.authentication != null}">
				<jsp:forward page = "error/error.jsp"/>
        		 <br />
    			</c:when>
   				 <c:when test="${sessionScope.authentication == 'notAuthenticated' && sessionScope.authentication != null}">
        		<h3 style="color:red;">Enter valid username and password</h3>
        		<c:remove var="authentication"/>
   			     <br />
    			</c:when>

				</c:choose>
   			</c:catch>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>