
<!--
Assignment :1
Assignment : Creating a user interaction form in jsp with validations
Author : Kailas
Date   : 16/8/2019
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<script type="text/javascript" src="vali.js"></script>
<link rel="stylesheet" type="text/css" href="userscss.css">

</head>

<body bgcolor=white>
	<form name="StudentRegistration" action="Userdetail"method="post"onsubmit="return(validate(event));">
		<table  style="border:1px solid black"cellpadding="5" width="40%" bgcolor="white" align="center"
			cellspacing="">

			<tr>
				<td style="border:1px solid black"colspan=2><legend align="left">Personal Details</legend></td>
			</tr>
	<tr>
				<td><label>User Name  <span style="color: red;">*</span></label></td>
				<td><input type=text name="username" id="username" size="20"
					pattern=".{4,}" required
					placeholder="Enter User name"title="Four or more characters"maxlength="8"></td>
			</tr>

			<tr>
				<td><label>Password <span style="color: red;">*</span></label></td>
				<td><input type="password" name="password" id="password"
					 pattern=".{6,}" required
						placeholder="Enter Password" title="Six or more characters"size="20" maxlength="12"></td>
			</tr>
			<tr>
				<td><label>Salutation :</label></td>
				<td><select name="scripts"id="scripts" autofocus>
					<option> </option>
						<option value="Mr">Mr</option>
						<option value="Miss">Miss</option>
						<option value="Dr">Dr</option>
				</select><br></td>
			</tr>


			<tr>
				<td><label>First Name <span style="color: red;">*</span></label></td>
				<td><input type=text name="firstname" id="firstname" size="20"
					required
					placeholder="Enter first name"maxlength="50"></td>
			</tr>

			<tr>
				<td><label>Middle Initial</label></td>
				<td><input type="text" name="middlename" id="middlename"
				size="20" maxlength="1"></td>
			</tr>

			<tr>
				<td><label>Last Name <span style="color: red;">*</span></label></td>
				<td><input type="text" name="lastname" id="lastname" size="20"
			required
					 placeholder="Enter last name"maxlength="50"></td>
			</tr>

			<tr>
				<td><label>Sex <span style="color: red;">*</span></label></td>
				<td><input type="radio" name="sex" id="myRadio"value="male" size="10"required><label>Male</label>
					<input type="radio" id="myRadio"name="sex" value="Female" size="10"required><label>Female</label></td>
			</tr>
			<p id="demo"></p>

			<tr>
				<td><label>Email Id <span style="color: red;">*</span></label></td>
				<td><input type="text" name="emailid" id="emailid" size="20"placeholder="e.g. xyz@gmail.com" ></td>
			</tr>


			<tr>
				<td><label> Birth Date <span style="color: red;">*</span></label></td>
				<td><select name="year" id="year" size="1">


						<option>select year</option>
						<option value="1990">1970</option>



                                                <option value="1991">1991</option>
                                                <option value="1992">1992</option>
                                                <option value="1993">1993</option>
                                                <option value="1994">1994</option>
                                                <option value="1995">1995</option>
                                                <option value="1996">1996</option>
                                                <option value="1997">1997</option>
                                                <option value="1998">1998</option>
                                                <option value="1999">1999</option>
                                                <option value="2000">2000</option>
												<option value="2001">2001</option>
												<option value="2002">2002</option>
                                                <option value="2003">2003</option>
                                                <option value="2004">2004</option>
                                                <option value="2005">2005</option>
                                                <option value="2006">2006</option>
                                                <option value="2007">2007</option>
                                                <option value="2008">2008</option>
                                                <option value="2009">2009</option>
                                                <option value="2010">2010</option>
                                                <option value="2011">2011</option>
                                                <option value="2012">2012</option>
                                                <option value="2013">2013</option>
                                                <option value="2014">2014</option>
												<option value="2015">2015</option>
												<option value="2016">2016</option>
												<option value="2017">2017</option>
												<option value="2018">2018</option>
												<option value="2019">2019</option>

												</select> <select name="month" id="month" size="1">
												<option>select month</option>
												<option value="1">January</option>
												<option value="2">February</option>
												<option value="3">March</option>
												<option value="4">April</option>
												<option value="5">May</option>
												<option value="6">June</option>
												<option value="7">July</option>
												<option value="8">August</option>
												<option value="9">September</option>
												<option value="10">October</option>
												<option value="11">November</option>
												<option value="12">December</option>
												</select>
                <select name="day"id="day">
											<option>select date</option>
              <script language="javascript"type="text/javascript">
									// to get 1 to 31 days used loop
							for (var d=1; d <= 31; d++)
							{
								document.write("<option>"+d+"</option>");
							}

				</script>
				</select>
				</td>
			</tr>

			<tr>
				<td><label>Address</label></td>
				<td><textarea style="resize: none" rows="4" cols="20"
						name="Address" id="Address" maxlength="100">
	</textarea></td>
			</tr>




			<tr>
				<td style="border:1px solid black"colspan=2><legend>
						Area Of Interest <span style="color: red;">*</span>
					</legend></td>
			</tr>

			<tr>
				<td colspan=2><input type="checkbox" name="web" id="web"value="web"><label>Web Programming</label><br>
					<input type="checkbox" name="web" id="database" value="database"><label>Database Programming</label><br>
						<input type="checkbox" name="web"id="swing" value="swing"><label>Swing Programming</label><br>
					<input type="checkbox" name="web" id="mobile" value="mobile"><label>Mobile
						Programming</label></td>
			</tr>


			<tr>
				<td style="border:1px solid black"colspan=2><label>Other Interest</label></td>
			</tr>

			<tr>
				<td><textarea style="resize: none" rows="4" cols="20"
						name="otherinterest" id="otherinterest" maxlength="100">
	</textarea></td>
			</tr>

			<tr>
				<td colspan=2><center>
						<input type="submit" value="Submit"><input type="button"
							name="clear" value="Clear" onclick="this.form.reset()">
					</center></td>
			</tr>
		</table>
	</form>
</body>
</html>
