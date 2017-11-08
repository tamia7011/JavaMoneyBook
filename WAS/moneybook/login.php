
<?php
$firstname = $_POST["firstname"];
$lastname = $_POST["lastname"];

# db 

# id is exist, move another page.
if(isset($firstname) && isset($lastname)){
	$result = strcmp($firstname,$lastname);
	if($result == 0){
		header("Location:/main.php");
	}
}
?>



<html>
<body>

<form action="/login.php" method="POST">
  First name:<br>
  <input type="text" name="firstname" value="">
  <br>
  Last name:<br>
  <input type="text" name="lastname" value="">
  <br><br>
  <input type="submit" value="Submit">
</form> 

<p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>
<h1><?php echo $firstname . " " . $lastname ;?>
<?php echo "<br>" . $result ?>
</body>
</html>


