<html>
<head>
	<title>DATA INSERT DEMO</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<h1>Expense</h1>
<form class="well well-lg"  action="/inputExpense.php" method="GET">
	 <?php 
		#email,name,type,date,price
	
		function make($data_name){
			echo "<div class='form-group'>";
			echo "<label for='".$data_name ."'>".$data_name ."</label>";
			echo "<input type='text' class='form-control' name='". $data_name . "' id='" . $data_name . "' placeholder='" . $data_name ."' />"; 
			echo "</div>";
		}
		make('email');
		make('name');
		make('price');
		make('date');
?>
	<div class='form-group'>
		<label class="checkbox-inline"><input type="checkbox" name="type" value="Fixed">Fixed</label>
		<label class="checkbox-inline"><input type="checkbox" name="type" value="Flexible">Flexible</label>
		<label class="checkbox-inline"><input type="checkbox" value="Waste" name="type">Waste</label>	
	</div>
	<div>
		<button class="btn btn-default" type="submit" id="login">Submit</button>
	</div>	
</form>

</body>
</html>
