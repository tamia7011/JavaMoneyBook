<?php
	//get session data
	session_start();
	$login_email = $_SESSION['email'];
	
	if(!isset($_SESSION['email'])){
		header("Location: /login.php");
		exit();
	}

	include 'dbms.php';

	$mileage_list = array();
	$sql = "select email, mileage from total";
	$result = $conn->query($sql);
	while($row = $result->fetch_assoc()){
		$mileage = $row['mileage'];
		$email = $row['email'];
		$data = array(
			"mileage" => $mileage,
			"email" => $email,
		);
		array_push($mileage_list,$data);
        	arsort($mileage_list);
	}
?>


<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>TEAM3'S MONEYBOOK</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<!-- chart js -->

</head>                                               
<body>
<div class="container">
	<div class="profile">
<div class="bg-1">
  <div class="container text-center">
<?php
	echo '<h1>' . RANKING . '</h1>';
?>

	<div class="point-history">
	<table class="table">
		<thead>
		<tr>
			<th>Email</th>
			<th>Mileage</th>
			<th>Rank</th>

		</tr>
		</thead>
		<tbody>
<?php
	$i = 1;
	foreach ($mileage_list as $data){
		echo "<tr>";	
		echo "<th>".$data["email"]."</th>";
		echo "<th>".$data["mileage"]."</th>";
		echo "<th>".$i."</th>";
		$i ++;
		echo "</tr>";	
	}
	
?>
		</tbody>
			
	</table>
	</div>
</div>


</body>
<script>
	
<?php

	echo "var mileage_list = [";
	for($i=0;$i < 12;$i++){
		echo '"' . $mileage_month_array[$i] . '"';
		if($i != 11){	
			echo ",";	
		}
	}
?>
</script>
</html>

