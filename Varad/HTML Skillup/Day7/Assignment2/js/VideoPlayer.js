
window.onload = function () {
  movie3();
}



function playPause() {
  var myVideo = document.getElementById("player");

  if (myVideo.paused)
    myVideo.play();
  else
    myVideo.pause();
}

function makeBig() {
  var myVideo = document.getElementById("player");

    console.log(window.innerWidth);
    myVideo.width = 720;

}

function makeSmall() {
  var myVideo = document.getElementById("player");

    myVideo.width = 320;

    console.log(myVideo.style);
    myVideo.style.marginLeft = "100px"

}

function makeNormal() {
  var myVideo = document.getElementById("player");

    myVideo.width = 500;
}


    function selectChannel(channelNumber) {
      let listItems = document.getElementById("tracks").getElementsByTagName("li");
      var length = listItems.length;
      for (var i = 0; i < length; i++) {
        listItems[i].className = i+1 == channelNumber ? "selected" : "";
      }
    }

    function movie1() {
        selectChannel(1);
        document.getElementById("player").src="videos/movie3.mp4";
    }
    function movie2() {
        selectChannel(2);
        document.getElementById("player").src="videos/movie2.mp4";
    }
    function movie3() {
        selectChannel(3);
        document.getElementById("player").src="videos/mov_bbb.mp4";
    }
