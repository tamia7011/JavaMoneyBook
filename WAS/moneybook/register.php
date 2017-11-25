<?php
include ("dbms.php"); 
 
$data_stream = "'".$_POST['email']."','".$_POST['password']."','".$_POST['name']."','".$_POST['phone_no']."'";
$sql = "INSERT INTO  user(email,password,name,phone_no) VALUES (".$data_stream.")";
$result = $conn->query($sql); 

echo ('가입이 완료되었습니다. 메인 화면으로 이동합니다..');
echo("<meta http-equiv='Refresh' content='1; URL=login.php'>");
 
?>
