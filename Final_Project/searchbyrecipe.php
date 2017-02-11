<?php
require_once 'unirest-php-master/src/Unirest.php';

$data = $_GET['data'];
//$data = "potato";
// These code snippets use an open-source library.
$response = Unirest\Request::get("https://spoonacular-recipe-food-nutrition-v1.p.mashape.com/recipes/search?query={$data}",
  array(
    "X-Mashape-Key" => "Y2ogMSClOImshBL7qICHAoQ0fFOdp1S6ogejsnYzFzmvTWAmiI"
  )
);
print_r(json_encode($response));


?>