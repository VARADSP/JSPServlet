// to validate all fields

function validate(event)
{


	var name=document.getElementById('firstname').value;
	if(name==null||name=="")
	    {
		document.StudentRegistration.firstname.focus() ;
	      return false;
	    }

var sal=document.getElementById('scripts').value;
if((sal=="Mr")&&(StudentRegistration.sex[0].checked == false ) )
    {
      alert ( "Please choose your Gender Properly: Male or Female");
      return false;
    }
else if((sal=="Miss")&&(StudentRegistration.sex[0].checked == true ) ){
  alert ( "Please choose your Gender Properly: Male or Female" );
  return false;
}

//email validation
var email = document.StudentRegistration.emailid.value;
atpos = email.indexOf("@");
dotpos = email.lastIndexOf(".");
if(email ==""||email==null){
alert("Please enter email ID")
document.StudentRegistration.emailid.focus() ;
return false;
}
else if(email != "" )
	{
    if (atpos < 1 || ( dotpos - atpos < 2 ))
      {
          alert("Please enter correct email ID")
          document.StudentRegistration.emailid.focus() ;
          return false;
      }
	}

// date of birth validation
   var year =document.getElementById('year').value;
   var month =document.getElementById('month').value;
   var day =document.getElementById('day').value;
     if( year == "select year" )
    {
    	 alert("Please select year")
    	 document.StudentRegistration.year.focus() ;
     return false;

    }
     if( month == "select month" )
     {
     	 alert("Please select month")
     	 document.StudentRegistration.month.focus() ;
      return false;

     }
     if( day == "select date" )
     {
     	 alert("Please select date")
     	 document.StudentRegistration.day.focus() ;
      return false;

     }

     var interest=document.getElementsByName('web[]')
     var otherinterest=document.forms[0].elements["otherinterest"].value;
 	otherinterest=otherinterest.trim();


 	  if(!valthisform())
 	   {
           if( otherinterest==""||otherinterest==null)
 		   {
           alert('select any one interest or write into other interest');
 		  return false;
            }
 	   }


    return( true );

}
// reset all text fields
function clearText()
{

	document.getElementById('StudentRegistration').reset();
}

// check all fields are filled then return true  then submit form
function valthisform() {
    var chkd = document.StudentRegistration.web.checked || document.StudentRegistration.database.checked||  document.StudentRegistration.swing.checked|| document.StudentRegistration.mobile.checked

    if (chkd)
	{
      return true; //Submit the form
    } else {

      return false; //not submitted
    }
  }
