<!--
 JSP page EditUserDetails used to edit user details using servlet with japanese language support
@author:varad paralikar
Created Date: 2019/8/19
-->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML utf-8>
<html>
  <head>
   <meta charset="UTF-8">
      <!--For adjusting view port for responsive layout-->
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="Content-Type"content="text/html;charset=utf-8">
 <title>User Details</title>
  </head>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <!--javascript to validate form data-->
  <script src="js/ValidateEditUserDetails2.js"></script>
  <style>
  	.header{
  	width:180%;
  	}

  </style>
  <body>
    <!--Container-->
    <div class="container">
      <!--Creating form-->
    <form name="loginForm" accept-charset="utf-8" action="UpdateUserDetails" method="post" onSubmit="return validateForm(event);">
   <input type="hidden" name="userId" value="${sessionScope.userId}" />
    <table cellspacing="5">
        <tr>
          <td class="header"><b>Personal Details</b></td>
        </tr>
        <tr> <!--input for salutation-->
          <td class="field_name"><b>Salutation</b></td>
          <td>
            <input list="sal" name="sal1" id="salutation" placeholder="Select salutation" value="${sessionScope.salutation}">
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
          <input type="text" id="fname" name="firstName" maxlength="50" placeholder="Enter your first name" value="${sessionScope.fname} ">
			<br>
		 <span id="errorname"></span>
		  </td>
        </tr>
        <tr> <!--input for middle name-->
          <td class="field_name"><b>Middle Name</b></td>
          <td>
          <input type="text" id="mname" name="middleName" maxlength="50" placeholder="Enter your middle name" value="${sessionScope.middle} ">
          </td>
        </tr>
        <tr> <!--input for last name-->
          <td class="field_name"><b>Last Name</b><i id="symbol">*</i></td>
          <td>
          <input type="text" id="lname" name="lastName" maxlength="50" placeholder="Enter your last name" value="${sessionScope.lname} ">
		  <br>
		  <span id="errorlname"></span>
          </td>
        </tr>
        <tr>
         <!--input for gender-->
          <td class="field_name"><b>Sex</b><i id="symbol">*</i></td>
          <td>
          				<c:choose>
					<c:when test="${sessionScope.sex == 'male'}">
			<input type="radio" name="gender" id="male" value="male" checked> Male
            <input type="radio" name="gender" id="female" value="female"> Female
        		</c:when>
        		<c:otherwise>
        		<input type="radio" name="gender" id="male" value="male"> Male
            <input type="radio" name="gender" id="female" value="female" checked> Female
        		</c:otherwise>
          	</c:choose>

			<br>
		  <span id="gender_error"></span>
          </td>

        </tr>
        <tr>
         <!--input for email id-->
          <td class="field_name"><b>Email Id</b></td>
          <td>
          <input type="email" name="emailId" id="emailid" maxlength="50" placeholder="Enter your email id" value="${sessionScope.email} ">
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
            <!-- <input type="date" id="date" > -->
            <select name="year" id="date" size="1" >
              <option>${sessionScope.year}</option>
              <option value="1960">1960</option>
              <option value="1961">1961</option>
                              <option value="1962">1962</option>
                              <option value="1963">1963</option>
                              <option value="1964">1964</option>
                              <option value="1965">1965</option>
                              <option value="1966">1966</option>
                              <option value="1967">1967</option>
                              <option value="1968">1968</option>
                              <option value="1969">1969</option>
                              <option value="1970">1970</option>
                              <option value="1971">1971</option>
                              <option value="1972">1972</option>
                              <option value="1973">1973</option>
                              <option value="1974">1974</option>
                            <option value="1975">1975</option>
                            <option value="1976">1976</option>
                            <option value="1977">1977</option>
                            <option value="1978">1978</option>
                            <option value="1979">1979</option>
                            <option value="1980">1980</option>
                            <option value="1981">1981</option>
                              <option value="1982">1982</option>
                              <option value="1983">1983</option>
                              <option value="1984">1984</option>
                              <option value="1985">1985</option>
                              <option value="1986">1986</option>
                              <option value="1987">1987</option>
                              <option value="1988">1988</option>
                              <option value="1989">1989</option>
                              <option value="1990">1990</option>
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
            </select>
              <select name="month" id="dateMonth" size="1" >
                <option id="firstMonthField">${sessionScope.month }</option>
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

                  <select name="day" id="dateDay" size="1">
              <option>${sessionScope.day}</option>
              <option></option>
            </select>

            <script>
              function daysInMonth(month, year) {
            	  document.getElementById('firstMonthField').innerHTML = "Month";
                var dd = new Date(year, month, 0);
                return dd.getDate();
              }
              function setDayDrop(dyear, dmonth, dday) {
                var year = dyear.options[dyear.selectedIndex].value;
                var month = dmonth.options[dmonth.selectedIndex].value;
                var day = dday.options[dday.selectedIndex].value;

                var days = (year == ' ' || month == ' ') ? 31 : daysInMonth(month, year);
                dday.options.length = 0;
                dday.options[dday.options.length] = new Option('Day',' ');
                // to get 1 to 31 days used loop
                for (var i = 1; i <= days; i++)
                dday.options[dday.options.length] = new Option(i, i);
              }

              function setDay() {
                var year = document.getElementById('date');
                var month = document.getElementById('dateMonth');
                var day = document.getElementById('dateDay');
                console.log(month.value);
                setDayDrop(year, month, day);
              }
              document.getElementById('dateMonth').onchange = setDay;
              document.getElementById('date').onchange = setDay;

            </script>
			 <br>
	  <span id="errorday" ></span>
          </td>

        </tr>
        <tr>
          <td class="field_name"><b>Address</b></td>
          <td>
          <textarea rows="4" cols="25" id="address" name="address" maxlength="50" placeholder="Enter your address">${sessionScope.address }</textarea>
          </td>
        </tr>
         <!--input for username-->
        <td class="field_name"><label for="uname"><b>UserName</b></label><span>*</span></td>
					<td><input type="text" name="uname" id="uname" maxlength="50"
						 placeholder="Enter your user name" value="${sessionScope.uname }" /><br>
						  <span id="erroruname"></span>
						  </td>
				</tr>
				<tr>
				 <!--input for password-->
					<td class="field_name"><label for="pass"><b>Password</b></label><span>*</span></td>
					<td><input type="password" name="pass" class="pass" id="pass"
						maxlength="50" placeholder="Enter your password" value="${sessionScope.password}" /><br>
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
          <c:set var="wp" value="false"/>
          <c:set var="sp" value="false"/>
          <c:set var="dp" value="false"/>
          <c:set var="mp" value="false"/>


		<c:forEach var="areaOfInterest" items="${sessionScope.interest}">
         <c:if test="${areaOfInterest.equals('webProgramming')}">
  			<c:set var="wp" value="true"/>
			<input id="wp" type="checkbox" name="interests" value="webProgramming" checked>Web Programming<br>
		</c:if>
		</c:forEach>

		<c:if test="${wp == false}">
		<c:set var="wp" value="false"/>
		 <input id="wp" type="checkbox" name="interests" value="webProgramming">Web Programming<br>
		</c:if>



		<c:forEach var="areaOfInterest" items="${sessionScope.interest}">
		<c:if test="${areaOfInterest.equals('databaseProgramming')}">
  			<c:set var="dp" value="true"/>
			<input id="dp" type="checkbox" name="interests" value="databaseProgramming" checked>Database Programming<br>
		</c:if>
		</c:forEach>

		<c:if test="${!dp}">
		<c:set var="dp" value="false"/>
				 <input id="dp" type="checkbox" name="interests" value="databaseProgramming">Database Programming<br>
		</c:if>

		<c:forEach var="areaOfInterest" items="${sessionScope.interest}">
		<c:if test="${areaOfInterest.equals('swingProgramming')}">
  			<c:set var="sp" value="true"/>
			<input id="sp" type="checkbox" name="interests" value="swingProgramming" checked>Swing Programming<br>
		</c:if>
		</c:forEach>
		<c:if test="${!sp}">
					<c:set var="sp" value="false"/>
				 <input id="sp" type="checkbox" name="interests" value="swingProgramming">Swing Programming<br>
		</c:if>


		<c:forEach var="areaOfInterest" items="${sessionScope.interest}">
		<c:if test="${areaOfInterest.equals('mobileProgramming')}">
  			<c:set var="mp" value="true"/>
			<input id="mp" type="checkbox" name="interests" value="mobileProgramming" checked>Mobile Programming<br>
		</c:if>
		</c:forEach>

		<c:if test="${!mp}">
		<c:set var="mp" value="false"/>
				 <input id="mp" type="checkbox" name="interests" value="mobileProgramming">Mobile Programming<br>
		</c:if>

          </td>

        </tr>
        <tr>
          <td class="field_name"><b>Other Interests</b></td>
        </tr>
        <tr style="float:left">
        <td>
          <textarea id="otherInterest"  rows="4" cols="25" style="overflow-y:scroll;" maxlength="100" name="otherInterests">${sessionScope.othinterest }</textarea>
            </td>
          </tr>

        <!--table row for buttons-->
        <tr>
        <td colspan="2" align="center"><button class="submit" onclick="validateForm(event);return false" type="submit"><b>Update</b>

            </td>
        </tr>
      </table>
    </form>
    </div>
    </body>
  </html>
