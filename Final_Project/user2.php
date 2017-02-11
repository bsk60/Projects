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

$username2 = $_POST['username2'];
$password2 = $_POST['password2'];

$sql = "INSERT INTO MyUser2(User, Pass)
VALUES('$username2', '$password2')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$sql = "SELECT id, User, Pass FROM MyUser2";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "id: " . $row["id"]. " - Username: " . $row["User"]. " - Pass: " . $row["Pass"]. "<br>";
    }
} else {
    echo "0 results";
}

$conn->close();
?>