<?php
    $productid = $_GET['productid'];
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
    
    $sql = "DELETE FROM inventory
            WHERE item='{$productid}'";
    $result = $conn->query($sql);
    $conn->close();