$(document).ready(function(){
 console.log("running"); 
   $("#recipesearch").submit(function(){
       event.preventDefault();
       console.log("in rechipesearch.submit");
   var data = $('#data').val();
   
    $.ajax({
           url: "store2.php",
           type: "GET",
           dataType: "html",
           data:{
             
           },
           success: function(result){
               console.log(result);
               for(var i = 0; i < Array.length; i++){
                  var placeholder = $('#recipepull').append(Array[i] + ",");
               }
               
               
               $.ajax({
                url: 'searchbyrecipe.php', // The URL to the API. You can get this in the API page of the API you intend to consume
                type: 'GET', // The HTTP Method, can be GET POST PUT DELETE etc
                data: {
                    data: placeholder
                    
                }, // Additional parameters here
                dataType: 'JSON',
                success: function(data) { 
                    console.log(data);
                     $('#recipepull').append('<div>'+ data.body.results[i].title + "</div>" + ' <img src="https://spoonacular.com/recipeImages/' + data.body.results[i].image + '"/>');; 
                    
                },
                error: function(err) { alert(err); },
                beforeSend: function(xhr) {
                xhr.setRequestHeader("X-Mashape-Authorization", "YOUR-MASHAPE-KEY"); // Enter here your Mashape key
    }
                });
               
           }       
        });
      
   });
});