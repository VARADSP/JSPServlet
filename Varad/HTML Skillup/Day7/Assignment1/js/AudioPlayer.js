//function for auto focus on login id on loading of page
window.onerror = function(error, url, line) {
    controller.sendLog({acc:'error', data:'ERR:'+error+' URL:'+url+' L:'+line});
};
window.onload = function () {
  sleepAway();
}


    function selectChannel(channelNumber) {
      let listItems = document.getElementById("tracks").getElementsByTagName("li");
      var length = listItems.length;
      for (var i = 0; i < length; i++) {
        listItems[i].className = i+1 == channelNumber ? "selected" : "";
      }
    }

    function volUp(){

      var element = document.getElementById("player");
             event.preventDefault();
             volume = element.volume;
             if (volume!=1) {
               try {
                  element.volume = volume + 0.1;
               }
               catch(error) {
                   element.volume = 1;
               }

             }
    }

    function volDown(){
      var element = document.getElementById("player");
              event.preventDefault();
              volume = element.volume;
              if (volume!=0) {
                try {
                    element.volume = volume - 0.1;
                }
                catch(error) {
                    element.volume = 0;
                }

              }
    }

    function kalimba() {
        selectChannel(1);
        document.getElementById("player").src="tracks/Kalimba.mp3";
    }
    function maid() {
        selectChannel(2);
        document.getElementById("player").src="tracks/Maid with the Flaxen Hair.mp3";
    }
    function sleepAway() {
        selectChannel(3);
        document.getElementById("player").src="tracks/Sleep Away.mp3";
    }
