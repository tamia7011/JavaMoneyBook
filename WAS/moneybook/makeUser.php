<!DOCTYPE html>
<html> 
<head>
    <meta charset="utf-8">
    <title>회원가입</title>
<style>
.myform{
	margin:10px;
	width:400px;
	padding:14px;
}

#stylized{
	border:solid 2px #b7ddf2;
	background:#ebf4fb;
}

#stylized h1{
	font-size:16px;
	font-weight:bold;
	margin-bottom:8px;
	font-family:nanumgothic,dotum;
}

#stylized p{
	font-size:11px;
	color:#666666;
	margin-bottom:solid 1px #b7ddf2;
	padding-bottom:10px;
	font-family:dotum;
}

#stylized label{
	display:block;
	font-weight:bold;
	text-align:right;
	width:140px;
	float:left;
	font-family:tahoma;
}

#stylized .small{
	color:#666666;
	display:block;
	font-size:11px;
	font-weight:normal;
	text-align:right;
	width:140px;
	font-family:dotum;
	letter-spacing:-1px;

#stylized input{
	float:left;
	font-size:12px;
	padding:4px 2px;
	border:solid 1px #aacfe4;
	width:200px;
	margin:2px 0 20px 10px;
}

#stylized button{
	clear:both;
	margin-left:150px;
	width:125px;
	height:31px;
	text-align:center;
	line-height:31px;
	background-color:#000;
	color:#FFFFFF;
	font-size:11px;
	font-weight:bold;
	font-family:tahoma;
}

</style>
</head>
<body>
  <div id="stylized" class="myform"> 
    <form action="register.php" data-ajax="false" method="post">
	<h1>회원 가입</h1>

	<label>
	<span class="name">이름</span>
	</label>
	<input type="text" id="Name" name="name"required><br>
	<label>
	<span class="email">Email</span>
        </label>
	<input type="text" id="email" name="email" required><br>
	<label>
	<span class="pw">PW</span>
        </label>
	<input type="password" id="Pw" name="password" required><br>
        <label>
	<span class="password">PW 확인</span>
        </label>
	<input type="password" id="PwCheck" required><br>
 	<label>
	<span class="phone">Phone Number</span>
	</label>
        <input type="text" id="Phone" name="phone_no" required><br>
 
        <br><br>
        <input type="submit" value="확인">
        <input type="reset" value="취소">
    </form>
   </div>
</body>
</html>
