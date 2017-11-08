<?php

$servername = "localhost:3306";
$username = "root";
$password = "password";
$dbname = "moneybook";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
	die("Connection failed: " . $conn->connect_error);
} 

#$sql = "SELECT * FROM expense";
#$result = $conn->query($sql);
#$result->num_rows # get num of row get 
#$row = $result->fetch_assoc()
#$row["id"]
#$conn->close();
?>
