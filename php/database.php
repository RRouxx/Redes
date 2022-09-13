<?php
$servername = "localhost";
$username = "Redes";
$password = "";
$dbname = "";

$name = $_POST["name"]; 
$mail = $_POST["email"];
$gender = $_POST["gender"];
$age = $_POST["age"];
$studies = $_POST["studies"];

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO Player (PersonID, Name, Score, Level)
VALUES (". $name . ".'" . $mail . $gender . $age . $studies;

if ($conn->query($sql) === TRUE) {
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
