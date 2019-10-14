
var isCompleted = false;

function cancel() {
	if(isCompleted == false){
		alert("Operation canceled!");
		  window.history.back();

	}
	else{
		alert("Upload completed!");
	}

}


function error(){

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');

	status.innerHTML = "Error occurred while uploading file!";
	progressBar.style.width = 0+"%";

}

function operationCompleted(size){

	console.log(size);

	var displaySize = document.getElementById('totalSize');

	displaySize.innerHTML = "Total Bytes Read " + size;

	isCompleted = true;
}


window.onload = function () {

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');
	status.innerHTML = "Uploading File";


	progressBar.style.width ="20%";


	var i=0;


	for(i=0;i<=100;i++){
		progressBar.innerHTML = i+"%";
		progressBar.style.width = i+"%";

	}
	status.innerHTML = "File Uploaded!"




	}