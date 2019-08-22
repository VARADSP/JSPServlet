
window.onload = function(){

	console.log("called from userDetails");

}

/*function getRadioVal to get radio box value
 * @form which is html form
 * @name which is name of radio boxes
 * return type : val which is value from radio boxes
 */
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



/*function validateForm to validate html form
 * @event which is submit event
 *return type:boolean
 */
function validateForm(event) {

	event.preventDefault();


  //getting mandotory fields for validation
	 var uname = document.getElementById('uname').value;
	 var password = document.getElementById('pass').value;
      var date=document.getElementById("date").value;
      var dateMonth=document.getElementById("dateMonth").value;
      var dateDay=document.getElementById("dateDay").value;


      console.log(dateDay);
      console.log(dateMonth);


      var fname=document.getElementById("fname").value;
      var lname=document.getElementById("lname").value;
  var sex = getRadioVal(document.loginForm,"gender");
      var email=document.getElementById("emailid").value;
      var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
  //checking all fields are empty or not
      if(fname==0 && lname==0 && ( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false )& email==0 &&  document.getElementById("date").value==0 && uname==0 && password==0){
        document.getElementById('errorname').innerHTML="Please enter the name";
        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="Please enter email id";
        document.getElementById('errorday').innerText="Please select date";
        document.getElementById('gender_error').innerText="Please select gender";
        document.getElementById('erroruname').innerText = "Please enter username";
        document.getElementById('errorpass').innerText = "Please enter password";

        console.log("In 1");
      }

      else if(fname==0 && lname==0 && ( document.getElementById("wp").checked==false
    	        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
    	        document.getElementById("mp").checked==false )& email==0 &&  document.getElementById("date").value==0 && uname!=0 && password!=0){

    	  document.getElementById('errorlname').innerHTML="Please enter last name";
          document.getElementById('errorname').innerHTML="Please enter first name";
          document.getElementById('gender_error').innerText="please select gender";


          document.getElementById('errorday').innerText="please select date";

          document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
          document.getElementById('erroremail').innerText="please enter email id";
          document.getElementById('erroruname').innerText = "";
          document.getElementById('errorpass').innerText = "";


      }


      else if(lname==0 && ( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&&document.getElementById("emailid").value==0 && uname==0 && password == 0){
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorday').innerText="please select date ";

        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";
        document.getElementById('gender_error').innerText="please select gender";
        document.getElementById('erroruname').innerText = "Please enter username";
        document.getElementById('errorpass').innerText = "Please enter password";
        console.log("In 2");
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

        console.log("In 3");
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
        console.log("In 4");

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
        console.log("In 5");
      }
      else if(uname != 0 && password != 0  && ( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false ) && document.getElementById('otherInterest').value.length == 0){
   	   document.getElementById('erroruname').innerText = "";
          document.getElementById('errorpass').innerText = "";

          document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
          console.log("In 6");
      }
     else if(uname != 0 && ( document.getElementById("wp").checked==false
             && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
             document.getElementById("mp").checked==false ) && document.getElementById('otherInterest').value.length == 0){
   	   document.getElementById('erroruname').innerText = "";
   	console.log("In 7");

     }
     else if(password != 0 && ( document.getElementById("wp").checked==false
             && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
             document.getElementById("mp").checked==false ) && document.getElementById('otherInterest').value.length == 0){
          document.getElementById('errorpass').innerText = "";
          console.log("In 8");

     }

      else if(( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false )&& document.getElementById("emailid").value==0 && date==0){
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorday').innerText="please enter email id";
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('erroremail').innerText="please enter email id";
        console.log("In 9");
      }
      else if(fname==0){
        document.getElementById('errorname').innerHTML="Please enter the name";
        document.getElementById('errorday').innerText="please select date";
        document.getElementById('gender_error').innerText="please select gender";
        document.getElementById('erroremail').innerText="please enter email id";

        console.log("In 10");
      }
      //checking lastname only
      else if(lname==0){


        document.getElementById('errorlname').innerHTML="Please enter the last name";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('erroraoi').innerHTML="";
        document.getElementById('erroremail').innerHTML="";
        console.log("In 11");
      }
      else if(reg.test(email)==false && email!=0){
        document.getElementById('erroremail').innerHTML="Invalid Emailid";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('erroraoi').innerHTML="";
        console.log("In 12");

      }


      //checking interests
      else if( document.getElementById("wp").checked==false
        && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
        document.getElementById("mp").checked==false && document.getElementById('otherInterest').value.length == 0 ){
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('erroremail').innerHTML="";
        console.log("In 13");
      }
      else if( document.getElementById("wp").checked==false
              && document.getElementById("dp").checked==false &&  document.getElementById("sp").checked==false &&
              document.getElementById("mp").checked==false && document.getElementById('otherInterest').value.length == 0 ){
        document.getElementById('erroraoi').innerHTML="Please select or enter area of interest";
        document.getElementById('errorname').innerHTML="";
        document.getElementById('errorlname').innerHTML="";
        document.getElementById('errorday').innerHTML="";
        document.getElementById('erroremail').innerHTML="";
        console.log("In 14");}
      else if (date==0 || dateMonth == "Month" || dateDay == " "){
        document.getElementById("errorday").innerHTML = "please select date";
        console.log("In 15");
      }

      else {
    	  console.log("In 16 last");


        //performing check for correct salutation
        if((sex == "male" && (document.getElementById('salutation').value == "Mrs." || document.getElementById('salutation').value == "Miss"))){

          document.getElementById('gender_error').innerText="please select correct gender";

          return false;
        }
        if(sex=="female" && document.getElementById('salutation').value == "Mr."){

          document.getElementById('gender_error').innerText="please select correct gender";
          return false;
        }
        document.loginForm.submit();// fire submit event

        reset();
        clear();
      }



}

/*function reseting which is used to reset the form fields
 * return type : void
 */
function reseting(){
  reset();
}

 /*
 function reset is used for the reset all contents.
 return type : void
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



       clear();

  }

  /*function clear is used to clear all error messages
  *return type:void
  */
  function clear() {
    document.getElementById('errorday').innerHTML="";
    document.getElementById('errorname').innerHTML="";
    document.getElementById('errorlname').innerHTML="";
    document.getElementById('erroraoi').innerHTML="";
    document.getElementById('erroremail').innerHTML="";
    document.getElementById('gender_error').innerText="";
    document.getElementById('erroruname').innerText = "";
    document.getElementById('errorpass').innerText = "";


  }

  /*
   * function drag which is used to tranfer data
   * return type : void
   */
  function drag(ev) {
      //set dragging data
      ev.dataTransfer.setData("text", ev.target.id);
    }

  /*
   * function allowDrop which is used to drop the dragged data
   * return type : void
   */
    function allowDrop(ev) {
      ev.preventDefault();
    }


    /*
     * function drop which is used to drop the data into dom elementa
     * return type : void
     */
    function drop(ev) {
      ev.preventDefault();
      var data = ev.dataTransfer.getData("text");
      //appen data to drop
      ev.target.appendChild(document.getElementById(data));
    }

/*function testCheckbox to check if text box is checked or not
 *
 * return type : boolean
 */
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
