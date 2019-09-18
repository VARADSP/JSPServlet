// Get modal elements
var modal = document.getElementById('simpleModal');
//Get open modal button
var modalBtn = document.getElementById('modalBtn');
//Get Close button
var closeBtn = document.getElementsByClassName('closeBtn')[0];


////Get modal elements
//var detailsModal = document.getElementById('detailsModal');
////Get open modal button
//var detailsModalBtn = document.getElementById('detailsBtn');
////Get Close button
//var detailsCloseBtn = document.getElementsByClassName('detailsCloseBtn')[0];
//



//Listen for open click
modalBtn.addEventListener('click',openModal);

//Listen for close click
closeBtn.addEventListener('click',closeModal);

//
////Listen for open click
//detailsModalBtn.addEventListener('click',detailsOpenModal);
//
////Listen for close click
//detailsCloseBtn.addEventListener('click',detailsCloseModal);
//

//for outside click

window.addEventListener('click',clickOutside);

//function to open modal
function openModal(){
    modal.style.display = 'block';
}

//function to close modal
function closeModal(){
  modal.style.display = 'none';
}
//
////function to open modal
//function detailsOpenModal(){
//    detailsModal.style.display = 'block';
//}
//
////function to close modal
//function detailsCloseModal(){
//  detailsModal.style.display = 'none';
//}
//


//function to close modal if outside click



function clickOutside(e){
  if(e.target == modal){
	  event.preventDefault();
    modal.style.display = 'none';
  }

}
