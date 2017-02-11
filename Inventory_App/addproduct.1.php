<?php
$productid = $_GET['productid'];
$product_amount = $_GET['product_amount'];
$servername = "sql5.freemysqlhosting.net";
$username = "sql5113785";
$password = "pRGzudm4JL";
$dbname = $username;

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "INSERT INTO inventory (item, count)
        VALUES ('{$productid}', {$product_amount})";
$result = $conn->query($sql);
$conn->close();