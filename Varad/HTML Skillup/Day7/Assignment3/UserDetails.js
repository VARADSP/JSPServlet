
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



  //getting mandotory fields for validation
      var date=document.getElementById("date").value;
      var fname=document.getElementById("fname").value;
      var lname=document.getElementById("lname").value;
  var sex = getRadioVal(document.loginForm,"gender");
      var email=document.getElementById("emailid").value;
      var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
  //checking all fields are empty or not
      if(fname==0 && lname==0 && ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false )& email==0 &&  document.getElementById("date").value==0){
        document.getElementById('errorname').innerHTML="Please enter the name";
        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";
        document.getElementById('errorday').innerText="please select date";
        document.getElementById('gender_error').innerText="please select gender";


      }

      else if(lname==0 && ( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&&document.getElementById("emailid").value==0){
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorday').innerText="please select date ";

        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";
        document.getElementById('gender_error').innerText="please select gender";

      }

      else if((sex == undefined &&  document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&& document.getElementById("emailid").value==0 && date==0){
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('gender_error').innerText="please select gender";


        document.getElementById('errorday').innerText="please select date";

        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";


      }
      else if((sex != undefined &&  document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&& document.getElementById("emailid").value==0 && date==0){
        document.getElementById('gender_error').innerText="";
        document.getElementById('errorday').innerText="please select date";

        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        if(reg.test(email)==false && email!=0){
          document.getElementById('erroremail').innerText="Invalid email";
        }else{
          document.getElementById('erroremail').innerText="Please enter email id";
        }


      }
      else if(( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&& date==0){
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorname').innerHTML="";

          if(reg.test(email)==false && email!=0){
            document.getElementById('erroremail').innerText="Invalid email";
          }else{
            document.getElementById('erroremail').innerText="";
          }


        document.getElementById('errorday').innerText="please select date";

        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="";

      }
      else if(( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&& document.getElementById("emailid").value==0 && date==0){
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorday').innerText="please enter email id";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";
      }
      else if(fname==0){
        document.getElementById('errorname').innerHTML="Please enter the name";
      }
      //checking lastname only
      else if(lname==0){


        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('erroraoi').innerHTML="";
        document.getElementById('erroremail').innerHTML="";
      }
      else if(reg.test(email)==false && email!=0){
        document.getElementById('erroremail').innerHTML="Invalid Emailid";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('erroraoi').innerHTML="";

      }


      //checking interests
      else if( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false ){
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('erroremail').innerHTML="";}
      else if( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false ){
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('erroremail').innerHTML="";}
      else if (date==0){
        document.getElementById("please select date");
      }

      else {




        //performing check for correct salutation
        if((sex == "male" && (document.getElementById('salutation').value == "Mrs." || document.getElementById('salutation').value == "Miss"))){
          alert("Please select correct salutation");
          return false;
        }
        if(sex=="female" && document.getElementById('salutation').value == "Mr."){
          alert("Please select correct salutation");
          return false;
        }

        alert("sucessfully submitted");
        reset();
        clear();
      }



}


function reseting(){
  reset();
}

 /*
 function reset is used for the reset all contents.
*/
  function reset() {

    document.getElementById("emailid").value=" ";

       document.getElementById("fname").value=" ";
       document.getElementById("date").value="";

       document.getElementById("mname").value=" ";
       document.getElementById("lname").value=" ";
       document.getElementById("address").value=" ";


       document.getElementById("wp").checked=false
       document.getElementById("dp").checked=false;
       document.getElementById("sp").checked=false;
       document.getElementById("mp").checked=false;
       document.getElementById("sal1").value="";
       document.location.reload();

       clear();

  }

  //function clear is used to clear all error messages
  function clear() {
    document.getElementById('errorday').innerHTML="";
    document.getElementById('errorname').innerHTML="";
    document.getElementById('errorlname').innerHTML="";
    document.getElementById('erroraoi').innerHTML="";
    document.getElementById('erroremail').innerHTML="";
    document.getElementById('gender_error').innerText="";
    document.getElementById("sal1").innerHTML="";

  }

  function drag(ev) {
      //set dragging data
      ev.dataTransfer.setData("text", ev.target.id);
    }

    function allowDrop(ev) {
      ev.preventDefault();
    }

    function drop(ev) {
      ev.preventDefault();
      var data = ev.dataTransfer.getData("text");
      //appen data to drop
      ev.target.appendChild(document.getElementById(data));
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
