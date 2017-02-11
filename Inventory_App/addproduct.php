<?php
    include 'database.php';
    
    $productid = $_GET['productid'];
    $product_amount = $_GET['product_amount'];
    $myDatabase = new Database();
    $myDatabase -> addProduct($productid, $product_amount);