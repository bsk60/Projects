$(document).ready(function(){
 console.log("running"); 
   $("#pic").submit(function(){
       event.preventDefault();
       console.log("in rechipesearch.submit");
   var data = $('#pics').val();
    $.ajax({
     url: 'searchbyrecipe.php', // The URL to the API. You can get this in the API page of the API you intend to consume
     type: 'GET', // The HTTP Method, can be GET POST PUT DELETE etc
     dataType:"JSON",
     data:{
       data: data,
      },
      success: function(result){
       console.log(result);
       for(var i =0; i < result.body.results.length; i++){
        $('#pictures').append('<img src="https://spoonacular.com/recipeImages/' + result.body.results[i].image + '"/>');
        
       }
      },
      error: function(JQXHR, textstatus, errorThrown){
       console.log("an error:" + errorThrown);
      }
     
    });
       
   });
});