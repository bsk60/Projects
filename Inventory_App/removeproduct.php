<?php
    include 'database.php';
    
    $productid = $_GET['productid'];
    $myDatabase = new Database();
    $myDatabase -> removeProduct($productid);