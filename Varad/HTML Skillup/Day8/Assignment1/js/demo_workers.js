var i = 0;

var isAmPm = (new Date().getHours()<12)?"AM":"PM";

function timedCount() {

  //Increments the counter variable by 1
  postMessage(new Date().toLocaleTimeString()+' ' + isAmPm);
  //return the current i value
  setTimeout("timedCount()",10);
  //set maximun timeout limit
}

timedCount();
