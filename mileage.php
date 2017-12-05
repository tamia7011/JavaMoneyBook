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
	$sql = "select expense.id,point,date,type,price from expense,mileage where expense.id = mileage.id and email='" . $login_email ."'";
	$result = $conn->query($sql);
	while($row = $result->fetch_assoc()){
		$point = $row['point'];
		$date = getDate(strtotime($row['date']));
		$type = $row['type'];
		$price = $row['price'];
		$data = array(
			"point" => $point,
			"date" => $date,
			"type" => $type,
			"price" => $price,
			
		);
		array_push($mileage_list,$data);	
	}
	$mileage_sum_list = array();
	$fixed_sum_list = array();
	$flexible_sum_list = array();
	$waste_sum_list = array();

	foreach($mileage_list as $data){
		$date = $data["date"];
		$key = $date['year'] . "-" . $date['mon']  ; #"0000-00"	
		if(!isset($sum_list[$key])){
			$mileage_sum_list[$key] = intval($data["point"]);
		}else{
			$mileage_sum_list[$key] += $data["point"];
		}	
		if(!strcmp($data['type'],"fixed")){
			if(!isset($fixed_sum_list[$key])){
				$fixed_sum_list[$key] = intval($data["price"]);
			}else{
				$fixed_sum_list[$key] += $data["price"];
			}		
		}
		if(!strcmp($data['type'],"flexible")){
			if(!isset($flexible_sum_list[$key])){
				$flexible_sum_list[$key] = intval($data["price"]);
			}else{
				$flexible_sum_list[$key] += $data["price"];
			}
		}
		if(!strcmp($data['type'],"waste")){
			if(!isset($waste_sum_list[$key])){
				$waste_sum_list[$key] = intval($data["price"]);
			}else{
				$waste_sum_list[$key] += $data["price"];
			}
		}
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
	echo '<h1>' . $login_email . '</h1>';
?>
    <img src="user.png" class="img-circle" alt="Bird" width="50" height="50">
  </div>
</div>

	</div>

	<div class="graph">
		<h1>Point Graph</h1>
		<canvas id="myChart"></canvas>
	</div>

	<div class="point-history">
	<table class="table">
		<thead>
		<tr>
			<th>Date</th>
			<th>Point</th>
			<th>Type</th>
		<!-- 	
			<th>Total Point</th>
			<th>fixed</th>
			<th>flexible</th>
			<th>waste</th>
		-->
		</tr>
		</thead>
		<tbody>
<?php
	
	foreach ($mileage_list as $data){
		echo "<tr>";	
		echo "<th>".$data["date"]."</th>";
		echo "<th>".$data["point"]."</th>";
		echo "<th>".$data["type"]."</th>";
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
	$year = "2017";
	$mileage_month_array = array();
	$fixed_month_array = array();
	$flexible_month_array = array();
	$waste_month_array = array();
	for($i = 1; $i < 13; $i++){
		$year_month_str = $year."-".$i;
		$mileage_month_sum = $mileage_sum_list[$year_month_str]; 
		$fixed_month_sum = $fixed_sum_list[$year_month_str];
		$flexible_month_sum = $flexible_sum_list[$year_month_str];
		$waste_month_sum = $waste_sum_list[$year_month_str];
		array_push($mileage_month_array,$mileage_month_sum);
		array_push($fixed_month_array,$fixed_month_sum);
		array_push($flexible_month_array,$flexible_month_sum);
		array_push($waste_month_array,$waste_month_sum);
	}
?>

<?php
	echo "var mileage_list = [";
	for($i=0;$i < 12;$i++){
		echo '"' . $mileage_month_array[$i] . '"';
		if($i != 11){	
			echo ",";	
		}
	}
	echo "];";

	echo "var fixed_list = [";
	for($i=0;$i < 12;$i++){
		echo '"' . $fixed_month_array[$i] . '"';
		if($i != 11){	
			echo ",";	
		}
	}
	echo "];";

	echo "var flexible_list = [";
	for($i=0;$i < 12;$i++){
		echo '"' . $flexible_month_array[$i] . '"';
		if($i != 11){
			echo ",";
		}
	}
	echo "];";

	echo "var waste_list = [";
	for($i=0;$i < 12;$i++){
		echo '"' . $flexible_month_array[$i] . '"';
		if($i != 11){
			echo ",";
		}
	}
	echo "];";
?>




var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx,{
type :'line',
	data:{
	labels: ["January", "February", "March", "April", "May", "June", "July","August","September","October","November","December"],
	datasets: [
	{
		label: "Mileage Point",
		backgroundColor: 'rgb(255, 99, 132)',
		borderColor: 'rgb(139, 0, 0)',
		data: mileage_list,
		
	},

	{
		label: "Fixed",
		backgroundColor: 'rgb(255,0,  132)',
		borderColor: 'rgb(255, 0, 132)',
		data: fixed_list,
	},

	{
		label: "Flexible",
		backgroundColor: 'rgb(26, 142, 72)',
		borderColor: 'rgb(45, 231, 21)',
		data: flexible_list,
	},

	{	
		label: "Waste",
		backgroundColor: 'rgb(24, 18, 132)',
		borderColor: 'rgb(10, 0, 99)',
		data: waste_list,
	
    	},

	]
     },
    options: {}
});


</script>
</html>

