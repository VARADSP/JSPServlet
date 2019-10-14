
window.onload = function () {
  var isAmPm = (new Date().getHours()<12)?"AM":"PM";

   document.getElementById("count").innerHTML= new Date().toLocaleTimeString()+ " " + isAmPm;
}

var w;


function startWorker(){
  /* check worker is supported or not in your browser*/
  if(typeof(Worker !== "undefined"))
  {
    /* check existance of  an worker*/
    if(typeof(w)=="undefined")
    {
      /* create object of worker with loading file*/
      //timedCount();
      w = new Worker("js/demo_workers.js");
    }
    /* print message is occusrs from clockWorker.js*/
    w.onmessage = function(event){
      /*set value of returned data to output tag*/
      document.getElementById("count").innerHTML = event.data;
    };
  }
  else{

    document.getElementById("count").innerHTML = "Web Worker not supported in Your browser";
  }
}
function stopWorker(){
  if(typeof(w) !== "undefined")
    {
      /* terminate the webWorker*/
      w.terminate();
      /* set WebWorker to Undifined*/
      w = undefined;
      /* reset value of counter*/
      var isAmPm = (new Date().getHours()<12)?"AM":"PM";

       document.getElementById("count").innerHTML= new Date().toLocaleTimeString()+ " " + isAmPm;
    }
}
