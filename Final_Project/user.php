<?php



    // A simple PHP script demonstrating how to connect to MySQL.
    // Press the 'Run' button on the top to start the web server,
    // then click the URL that is emitted to the Output tab of the console.
    
    //localhost: 127.0.0.1
    //username: bsk60
    //database: C9
    
    //$servername = getenv('IP'); //connection id:50 
    //$username = getenv('C9_USER');
    $servername = "127.0.0.1";
    $username = "bsk60";
    $password = "";
    $database = "c9";
    $dbport = 3306;
    
    define('DB_HOST', $servername);
    define('DB_USER', $username);
    define('DB_PASSWORD', '');
    define('DB_NAME', 'c9');
    
    
    // Create connection
    $db = new mysqli($servername, $username, $password, $database, $dbport);

    // Check connection
    if ($db->connect_error) {
        die("Connection failed: " . $db->connect_error);
    } 
    echo "Connected successfully (".$db->host_info.")";

   
    $sql = "CREATE TABLE MyUser2(
        id INT(30) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
        User VARCHAR(20) NOT NULL, 
        Pass VARCHAR(20) NOT NULL
    )";
    
    
    if ($db->query($sql) === TRUE) {
    echo "Table MyUser created successfully";
    } else {
    echo "Error creating table: " . $db->error;
    }
    
    $db->close();
    
   // $sql = "INSERT INTO MyIngredients(Ingredients, Quantity)
    //VALUES ('$ingredients', '$quantity')";
    
    //$sql = "SELECT id, Ingredients, Quantity FROM MyIngredients";
    //$result = mysqli_query($db, $sql);
    
    //if(mysqli_num_rows($result) > 0){
    
    //echo "id: " .$row["id"]. "Ingredient" .$row["Ingredients"]. " " .$row["Quantity"]."<br>";
    //}
    //else{
      //  echo "0 results";
    //}
    
?>