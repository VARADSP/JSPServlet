
//function to get radio box value
function getRadioVal(form, name) {
    var val;
    // get list of radio buttons with specified name
    var radios = form.elements[name];

    // loop through list of radio buttons
    for (var i=0, len=radios.length; i<len; i++) {
        if ( radios[i].checked ) { // radio checked?
            val = radios[i].value; // if so, hold its value in val
            break; // and break out of for loop
        }
    }
    return val; // return value of checked radio or undefined if none checked
}

function clearErrorMessage() {
    document.getElementById("firstName_error").innerHTML = "";
    document.getElementById("lastName_error").innerHTML = "";
	document.getElementById("gender_error").innerHTML = "";
	document.getElementById("date_error").innerHTML = "";
	document.getElementById("areaOfInterest_error").innerHTML = "";
  }





//function to validate form
function validateForm() {
  var firstName = document.loginForm.firstName;
  var salutation = document.loginForm.salutation;
  var selectedSalutation = salutation.options[salutation.selectedIndex].text;
  //selectedSalutation can be Select Salutation
  var middleName = document.loginForm.middleName;
  var lastName = document.loginForm.lastName;

  var gender = document.loginForm.gender;
  var sex = getRadioVal(document.loginForm,"gender");

  var emailId = document.loginForm.emailId.value;
  var birthDateDay = document.loginForm.day;
  var birthDateMonth = document.loginForm.month;
  var birthDateYear = document.loginForm.year;
  var selectedbirthDateDay = birthDateDay.options[birthDateDay.selectedIndex].text;
  var selectedbirthDateMonth = birthDateMonth.options[birthDateMonth.selectedIndex].text;
  var selectedbirthDateYear = birthDateYear.options[birthDateYear.selectedIndex].text;




  var address = document.loginForm.address.value;

  var oCheckBox1 = document.loginForm.elements["webProgramming"];
  var oCheckBox2 = document.loginForm.elements["databaseProgramming"];
  var oCheckBox3 = document.loginForm.elements["swingProgramming"];
  var oCheckBox4 = document.loginForm.elements["mobileProgramming"];

  var otherInterests = document.loginForm.otherInterests.value;


 //getting mandotory fields for validation
    var fname=firstName.value;
    var lname=lastName.value;
    var day=selectedbirthDateDay;
    var month=selectedbirthDateMonth;
    var year=selectedbirthDateYear;
    var area=otherInterests;
    var email=emailId;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
//checking all fields are empty or not
    if(fname==0 && sex==undefined && lname==0 && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked==false
      && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
      document.getElementById("mp").checked==false && area==0)){
      document.getElementById('firstName_error').innerHTML="Please enter the name";
      document.getElementById('lastName_error').innerHTML="Please enter the last name";
      document.getElementById('date_error').innerHTML="Please enter the date of birth";
      document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
      document.getElementById('gender_error').innerHTML = "Please select gender";
    }

	else if(lname==0 && sex==undefined && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked==false
      && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
      document.getElementById("mp").checked==false && area==0)){
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="Please enter the last name";
      document.getElementById('date_error').innerHTML="Please enter the date of birth";
      document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
      document.getElementById('gender_error').innerHTML = "Please select gender";
    }
    else if(fname==0 && lname != 0 && sex == undefined && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false && area==0)){
      document.getElementById('firstName_error').innerHTML="Please enter the name";
      document.getElementById('date_error').innerHTML="Please enter the date of birth";
      document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
      document.getElementById('gender_error').innerHTML = "Please select gender";
    }
    //checking lastname only
    else if(lname==0 && fname !=0 && sex == undefined && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false && area==0) ){



      document.getElementById('lastName_error').innerHTML="Please enter the last name";
      document.getElementById('date_error').innerHTML="Please enter the date of birth";
      document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
      document.getElementById('gender_error').innerHTML = "Please select gender";

    }

    else if(lname==0 && fname ==0 && sex != undefined && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false && area==0)){
          document.getElementById('firstName_error').innerHTML="Please enter the name";
          document.getElementById('lastName_error').innerHTML="Please enter the last name";
          document.getElementById('date_error').innerHTML="Please enter the date of birth";
          document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
    }
    else if(lname==0 && fname ==0 && sex == undefined && (day!="Date"||month!="Month"|| year!="Year")&& ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false && area==0)){
          document.getElementById('firstName_error').innerHTML="Please enter the name";
          document.getElementById('lastName_error').innerHTML="Please enter the last name";
          document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
          document.getElementById('gender_error').innerHTML = "Please select gender";
    }

    else if(lname==0 && fname ==0 && sex == undefined && (day=="Date"&&month=="Month"&& year=="Year")&& ( document.getElementById("wp").checked!=false
        || document.getElementById("dp").checked!=false ||  document.getElementById("sp").checked!=false ||
        document.getElementById("mp").checked!=false || area!=0)){
          document.getElementById('firstName_error').innerHTML="Please enter the name";
          document.getElementById('lastName_error').innerHTML="Please enter the last name";
          document.getElementById('date_error').innerHTML="Please enter the date of birth";
          document.getElementById('gender_error').innerHTML = "Please select gender";
    }
    //checking overall date
    else if(day=="Date"&&month=="Month"&& year=="Year" && fname!=0&&lname!=0&&sex!=undefined){
      document.getElementById('date_error').innerHTML="Please enter the date of birth";
          document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";


  }
    //checking day only
    else if(day=="Date"){
      document.getElementById('date_error').innerHTML="Please enter the day of birth";
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="";
      document.getElementById('areaOfInterest_error').innerHTML="";

    }
    //checking month only
    else if(month=="Month"){
      document.getElementById('date_error').innerHTML="Please enter the month of birth";
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="";
      document.getElementById('areaOfInterest_error').innerHTML="";

    }
    //checking year
    else if(year=="Year"){
      document.getElementById('date_error').innerHTML="Please enter the year of birth";
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="";
      document.getElementById('areaOfInterest_error').innerHTML="";

    }
    else if((year%4==0 && day>29 && month==2 )||(year%4!=0 && day>28 && month==2 )){
      document.getElementById('date_error').innerHTML="Invalid date you entered";
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="";
      document.getElementById('areaOfInterest_error').innerHTML="";

    }

    //checking interests
    else if( document.getElementById("wp").checked==false
      && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
      document.getElementById("mp").checked==false && area==0){
      document.getElementById('areaOfInterest_error').innerHTML="Please select or enter area of interest";
      document.getElementById('firstName_error').innerHTML="";
      document.getElementById('lastName_error').innerHTML="";
      document.getElementById('date_error').innerHTML="";
   }
    else {
      alert("sucessfully submitted");
      reset();
      clear();
    }


}

 /*
the below function is used for the reset all contents.
*/
  function reset() {

   document.getElementById("firstName_error").innerHTML = "";
    document.getElementById("lastName_error").innerHTML = "";
	document.getElementById("gender_error").innerHTML = "";
	document.getElementById("date_error").innerHTML = "";
	document.getElementById("areaOfInterest_error").innerHTML = "";

    clear();

  }
  function  clear() {
    document.getElementById("firstName_error").innerHTML = "";
    document.getElementById("lastName_error").innerHTML = "";
	document.getElementById("gender_error").innerHTML = "";
	document.getElementById("date_error").innerHTML = "";
	document.getElementById("areaOfInterest_error").innerHTML = "";



  }


//function testCheckbox to check if text box is checked or not
function testCheckbox(oCheckbox)
{
    var checkbox_val = oCheckbox.value;
    if (oCheckbox.checked == true)
    {
      return true;
    }
    else
    {
      return false;
    }
}
