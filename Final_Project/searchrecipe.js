$(document).ready(function(){
 console.log("running"); 
   $("#recipesearch").submit(function(){
       event.preventDefault();
       console.log("in rechipesearch.submit");
   var data = $('#data').val();
   /*var placeholder = "";
    $.ajax({
           url: "store2.php",
           type: "GET",
           dataType: "html",
           data:{
               ingredients: ingredients,
           },
           success: function(result){
               placeholder.html(result);
               
               $.ajax({
                url: 'https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients/', // The URL to the API. You can get this in the API page of the API you intend to consume
                type: 'GET', // The HTTP Method, can be GET POST PUT DELETE etc
                data: {ingredients: placeholder}, // Additional parameters here
                dataType: 'JSON',
                success: function(data) { console.dir((data.source)); $('#behold').html(data); },
                error: function(err) { alert(err); },
                beforeSend: function(xhr) {
                xhr.setRequestHeader("X-Mashape-Authorization", "YOUR-MASHAPE-KEY"); // Enter here your Mashape key
    }
                });
               
           }       
        });
     */  
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
        $('#behold').append('<div>'+ result.body.results[i].title + "</div>" + ' <img src="https://spoonacular.com/recipeImages/' + result.body.results[i].image + '"/>');
        
       }
      },
      error: function(JQXHR, textstatus, errorThrown){
       console.log("an error:" + errorThrown);
      }
     
    });
       
   });
});