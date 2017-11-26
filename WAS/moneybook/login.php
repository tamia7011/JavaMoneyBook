<?php
include 'login_verf.php';

$email = $_GET["email"];
$pwd = $_GET["pwd"];


# id is exist, move another page.
if(isset($email) && isset($pwd)){
	$result = verification($conn,$email,$pwd);		
	if($result == True){
		session_start();
		$_SESSION['email'] = $email;
		//session 
		//connect
		//email
		header("Location:/main.php");
	}
}
?>

<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
body {
	background-color: #f4511e;
}
.ld{
	margin : 100px auto;
	width : 80%;
	text-align:center;
}

.form-group{
	text-align:left;
}

</style>
</head>
<body>    
<div class="container ld">
<h1>MoneyBook</h1>
<form class="well well-lg"action="/login.php" method="GET">
  <div class="form-group">
	<label for="email">Email : </label>
	<input type="text" class="form-control" name="email" id="email" placeholder="Enter Email"/>
  </div>

  <div class="form-group">
	<label for="password">Password :</label>
	<input type="password" class="form-control" name="pwd" id="password" placeholder="password" />
  </div>

  <div>
	<button class="btn btn-default" type="submit" id="login">Login</button>
	<button class="btn btn-default" type="button" onclick="location.href='makeUser.php'" id="sign-in">Sign in</button>
  </div>
 </div>
</form> 

</body>
</html>


