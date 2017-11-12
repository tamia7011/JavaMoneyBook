<?php
	include 'dbms.php';
	
	function verification($conn,$id,$password)
	{
		#db
		echo $id . $password;

		$sql = "SELECT * FROM user";
		$result = $conn->query($sql);
		while($row=$result->fetch_assoc()){
			$email = $row['email'];
			$pw = $row['password'];
			if(strcmp($email,$id) == 0 && strcmp($pw,$password)==0){
				return True;
			}	
			
		}
		return False;
	}

?>
