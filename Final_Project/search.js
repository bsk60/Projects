$(document).ready(function(){
  console.log("running");
   $("#form2").submit(function(){
       event.preventDefault();
        console.log("in form2");
   var videosearch = $('#videosearch').val();
   
    $.ajax({
           url: "https://www.googleapis.com/youtube/v3/search",
           type: "GET",
           dataType: "JSON",
           data:{
               q: videosearch,
               part: "snippet",
               key: "AIzaSyC7rAPSMRdH11rQnptwFmzQ7sJHR78-gZ4",
               type: 'video'
           },
           success: function(result){
               console.log(result);
               for(var i =0; i < result.items.length; i++){
                    $('#output').append('<iframe width="360" height="315" src="https://www.youtube.com/embed/" ' + result.items[i].id.videoId + '"frameborder="0" allowfullscreen>"' + '"</iframe">');
                   
               }
           },
           error: function(jqXHR, textStatus, errorThrown){
               console.log(errorThrown);
           }
        });
       
   });
});
