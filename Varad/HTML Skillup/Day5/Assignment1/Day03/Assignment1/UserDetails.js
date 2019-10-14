
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

//function to validate form
function validateForm() {
  var firstName = document.loginForm.firstName.value;

  if(firstName == ""){
    alert("Please enter first name");
    return false;
  }

  var salutation = document.loginForm.salutation;
  var selectedSalutation = salutation.options[salutation.selectedIndex].text;
  //selectedSalutation can be Select Salutation
  var middleName = document.loginForm.middleName.value;
  var lastName = document.loginForm.lastName.value;
  if(lastName == ""){
    alert("Please enter last name");
    return false;
  }
  var gender = document.loginForm.gender;
  var sex = getRadioVal(document.loginForm,"gender");
  //sex can be undefined
  if(sex == undefined){
    alert("Please select your gender");
    return false;
  }

  var emailId = document.loginForm.emailId.value;
  var birthDateDay = document.loginForm.day;
  var birthDateMonth = document.loginForm.month;
  var birthDateYear = document.loginForm.year;
  var selectedbirthDateDay = birthDateDay.options[birthDateDay.selectedIndex].text;
  var selectedbirthDateMonth = birthDateMonth.options[birthDateMonth.selectedIndex].text;
  var selectedbirthDateYear = birthDateYear.options[birthDateYear.selectedIndex].text;

  if(selectedbirthDateDay == "select date" && selectedbirthDateMonth == "select month" && selectedbirthDateYear == "select year"){
    alert("Please enter birth date");
    return false;
  }
  else if(selectedbirthDateMonth == "select month"){
    alert("Please select month in birth date")
    return false;
  }
  else if(selectedbirthDateDay == "Day"){

    console.log(birthDateDay);
    birthDateDay.focus();
    return false;
  }
  else if(selectedbirthDateYear == "select year"){
    alert("Please select year in birth date")
    return false;
  }


  var address = document.loginForm.address.value;

  var oCheckBox1 = document.loginForm.elements["webProgramming"];
  var oCheckBox2 = document.loginForm.elements["databaseProgramming"];
  var oCheckBox3 = document.loginForm.elements["swingProgramming"];
  var oCheckBox4 = document.loginForm.elements["mobileProgramming"];

  var otherInterests = document.loginForm.otherInterests.value;

  if(!testCheckbox(oCheckBox1) && !testCheckbox(oCheckBox2) && !testCheckbox(oCheckBox3) && !testCheckbox(oCheckBox4) && otherInterests == ""){
      oCheckBox1.required = true;
      return false;
  }
  //performing check for correct salutation
  if((sex == "male" && (selectedSalutation == "Mrs." || selectedSalutation == "Miss"))){
    alert("Please select correct salutation");
    return false;
  }
  if(sex=="female" && selectedSalutation == "Mr."){
    alert("Please select correct salutation");
    return false;
  }

//returning true if passed all validations
  alert("Data submitted successfully");
  return true;
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
