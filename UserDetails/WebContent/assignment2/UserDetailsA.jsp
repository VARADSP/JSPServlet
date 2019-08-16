<!-- JSP page UserDetailsA used to save user details using servlet into the database
@author:varad paralikar
Created Date: 2019/8/14
-->
<!DOCTYPE HTML utf-8>
<html>
  <head>
      <!--For adjusting view port for responsive layout-->
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="Content-Type"content="text/html;charset=utf-8">
 <title>User Details</title>
  </head>
  <link rel="stylesheet" type="text/css" href="style.css">
  <!--javascript to validate form data-->
  <script src="UserDetailsA.js"></script>
  <body>
    <!--Container-->
    <div class="container">
      <!--Creating form-->
    <form name="loginForm" action="UserDetailsA" method="post" onSubmit="return validateForm(event);">
     <table cellspacing="5">
        <tr>
          <td class="header"><b>Personal Details</b></td>
        </tr>
        <tr> <!--input for salutation-->
          <td class="field_name"><b>Salutation</b></td>
          <td>
            <input list="sal" name="sal1" id="salutation" placeholder="Select salutation">
          						<datalist id="sal">
          							<option value="Mr.">
          							<option value="Miss">
          							<option value="Mrs.">
          						</datalist>
          </td>
        </tr>
        <tr> <!--input for first name-->
          <td class="field_name"><b>First Name</b><i id="symbol">*</i></td>
          <td>
          <input type="text" id="fname" name="firstName" maxlength="50" placeholder="Enter your first name">
			<br>
		 <span id="errorname"></span>
		  </td>
        </tr>
        <tr> <!--input for middle name-->
          <td class="field_name"><b>Middle Name</b></td>
          <td>
          <input type="text" id="mname" name="middleName" maxlength="50" placeholder="Enter your middle name">
          </td>
        </tr>
        <tr> <!--input for last name-->
          <td class="field_name"><b>Last Name</b><i id="symbol">*</i></td>
          <td>
          <input type="text" id="lname" name="lastName" maxlength="50" placeholder="Enter your last name">
		  <br>
		  <span id="errorlname"></span>
          </td>
        </tr>
        <tr>
         <!--input for gender-->
          <td class="field_name"><b>Sex</b><i id="symbol">*</i></td>
          <td>
            <input type="radio" name="gender" id="male" value="male"> Male
            <input type="radio" name="gender" id="female" value="female"> Female
			<br>
		  <span id="gender_error"></span>
          </td>

        </tr>
        <tr>
         <!--input for email id-->
          <td class="field_name"><b>Email Id</b></td>
          <td>
          <input type="email" name="emailId" id="emailid" maxlength="50" placeholder="Enter your email id">
            <br>
             <span id="erroremail"></span>
          </td>
        </tr>
        <tr>
         <!--input for birth date-->
          <td class="field_name">
            <b>Birth Date </b><i id="symbol">*</i>
          </td>
          <td>

               <input type="date" name="date" id="date"><br/>

	  <span id="errorday"></span>
          </td>

        </tr>
        <tr>
          <td class="field_name"><b>Address</b></td>
          <td>
          <textarea rows="4" cols="25" id="address" name="address" maxlength="50" placeholder="Enter your address"></textarea>
          </td>
        </tr>
         <!--input for username-->
        <td><label for="uname"><b>UserName</b></label><span>*</span></td>
					<td><input type="text" name="uname" id="uname" maxlength="50"
						 placeholder="Enter your user name" /><br>
						  <span id="erroruname"></span>
						  </td>
				</tr>
				<tr>
				 <!--input for password-->
					<td><label for="pass"><b>Password</b></label><span>*</span></td>
					<td><input type="password" name="pass" class="pass" id="pass"
						maxlength="50" placeholder="Enter your password" /><br>
						 <span id="errorpass"></span>
						 </td>
				</tr>
        <tr>
         <!--input for area of interest-->
          <td class="header"><b>Area Of Interest</b><i id="symbol">*</i>
		   <br>
		 <span id="erroraoi"></span>
   </td>

        </tr>
        <tr>

		  <br>
		   <!--input check boxes-->
          <td>
            <input id="wp" type="checkbox" name="interests" value="webProgramming">Web Programming<br>
            <input id="dp" type="checkbox" name="interests" value="databaseProgramming">Database Programming<br>
            <input id="sp" type="checkbox" name="interests" value="swingProgramming">Swing Programming<br>
            <input  id="mp" type="checkbox" name="interests" value="mobileProgramming">Mobile Programming<br>
          </td>

        </tr>
        <tr>
          <td class="field_name"><b>Other Interests</b></td>
        </tr>
        <tr style="float:left">
        <td>
          <textarea  rows="4" cols="25" style="overflow-y:scroll;" maxlength="100" name="otherInterests"></textarea>
            </td>
          </tr>

        <!--table row for buttons-->
        <tr>
        <td colspan="2" align="center"><button class="submit" onclick="validateForm();return false" type="submit"><b>Submit</b>
          <button class="clear" type="reset" onclick="reseting()">Clear</button>
            </td>
        </tr>
      </table>

    </form>
    </div>
    </body>
  </html>
