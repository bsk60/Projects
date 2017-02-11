<?php
require_once 'unirest-php-master/src/Unirest.php';

// These code snippets use an open-source library.
$response = Unirest\Request::get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/findByIngredients?fillIngredients=false&ingredients=apples%2Cflour%2Csugar&limitLicense=false&number=5&ranking=1",
  array(
    "X-Mashape-Key" => "Y2ogMSClOImshBL7qICHAoQ0fFOdp1S6ogejsnYzFzmvTWAmiI",
    "Accept" => "application/json"
  )
);
print_r($response);
?>