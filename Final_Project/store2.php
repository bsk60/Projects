<?php
    $servername = "127.0.0.1";
    $username = "bsk60";
    $password = "";
    $database = "c9";
    $dbport = 3306;
    

// Create connection
$conn = new mysqli($servername, $username, $password, $database, $dbport);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$ingredients2 = $_POST['ingredients'];
$quantity2 = $_POST['quantity'];

$sql2 = "INSERT INTO MyIngredients2 (Ingredients, Quantity)
VALUES ('$ingredients2', '$quantity2')";

if ($conn->query($sql2) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$sql2 = "SELECT id, Ingredients, Quantity FROM MyIngredients2";
$result = $conn->query($sql2);

if ($result->num_rows > 0) {
    // output data of each row
    $array = array();
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " - Ingredient: " . $row["Ingredients"]. " " . $row["Quantity"]. "<br>";
        $array[] = $row;
    }
} else {
    echo "0 results";
}
$test = json_encode($array);
$test = $array;
echo '<pre>';
//print_r($test);
echo '</pre>';
$conn->close();
?>