$(document).ready(function(){
  
   $("#manage").submit(function(){
       event.preventDefault();
   
   var ingredients = $('#ingredients').val();
   var quantity = $('#quantity').val();
   
    $.ajax({
           url: "store2.php",
           type: "POST",
           dataType: "html",
           data:{
               ingredients: ingredients,
               quantity: quantity,
           },
           success: function(result){
               $('#goodjob').html(result);
           }       
        });
       
   });
});