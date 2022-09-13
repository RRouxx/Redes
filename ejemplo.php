<!DOCTYPE html>
<html>
<head>
<tittle>RR Page</tittle>
	<link rel="stylesheet" href="csss/style.css">
	<script src="js/codigo.js"></script>
</head>
<body>
<?php
echo "My first PHP script!";
?>

<?php
$t = date("H");
if ($t < "24"){
	echo "Have a good day!";
} else{
	echo "Have a good night!";
}
?>
<h1> This is a Heading </h1>
<p> This is a paragrahp</p>


</body>