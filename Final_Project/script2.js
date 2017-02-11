$(document).ready(function(){
  
   $("#signupsubmit").submit(function(){
       event.preventDefault();
   
   var username2 = $('#username2').val();
   var password2 = $('#password2').val();
   
    $.ajax({
           url: "user2.php",
           type: "POST",
           dataType: "html",
           data:{
               username2: username2,
               password2: password2,
           },
           success: function(serverResponse){
               $('#goodjob').append("<div> You have successfully registered!</div>");
           }       
        });
       
   });
});