<html>
<head>
</head>
<body>
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
		
	}
	$year = "2017";
	$mileage_month_array = array();
	$fixed_month_array = array();
	for($i = 1; $i < 13; $i++){
		$year_month_str = $year."-".$i;
		$mileage_month_sum = $mileage_sum_list[$year_month_str]; 
		$fixed_month_sum = $fixed_sum_list[$year_month_str];
		array_push($mileage_month_array,$mileage_month_sum);
		array_push($fixed_month_array,$fixed_month_sum);
	}
	echo var_dump($fixed_month_array);
	
?>
</body
</html>
