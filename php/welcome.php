<html>
<body>

<?php

$name = $_POST["name"]; 
$mail = $_POST["email"];
$gender = $_POST["gender"];
$age = $_POST["age"];
$studies = $_POST["studies"];


echo "name: " . $name . "\n<br>mail: " . $mail . "\n<br>gender: " . $gender
. "\n<br>age: " . $age . "\n<br>studies: " . $studies;

?>

</body>
</html>