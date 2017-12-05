<?php
include ("dbms.php"); 
 
$data_stream = "'".$_POST['email']."','".$_POST['password']."','".$_POST['name']."','".$_POST['phone_no']."'";
$sql = "INSERT INTO  user(email,password,name,phone_no) VALUES (".$data_stream.")";
$sql = "INSERT INTO  total(fixed,flexible,discretionary,total,email,budget,mileage,salary) VALUES ('0','0','0','0','".$_POST['email']."','0','0','0')";
$result = $conn->query($sql); 

echo ('가입이 완료되었습니다. 메인 화면으로 이동합니다..');
echo("<meta http-equiv='Refresh' content='2; URL=login.php'>");
 
?>
