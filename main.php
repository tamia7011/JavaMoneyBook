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
 
 <style>
  body {
      font: 400 15px Lato, sans-serif;
      line-height: 1.8;
      color: #818181;
  }
 
  h2 {
      font-size: 24px;
      text-transform: uppercase;
      color: #303030;
      font-weight: 600;
      margin-bottom: 30px;
  }

  h4 {
      font-size: 19px;
      line-height: 1.375em;
      color: #303030;
      font-weight: 400;
      margin-bottom: 30px;
  }

  .jumbotron {
      background-color: #f4511e;
      color: #fff;
      padding: 100px 25px;
      font-family: Montserrat, sans-serif;
  }

  .container-fluid {
      padding: 60px 50px;
  }

  .container-fluid bg-grey{
	padding: 60px 50px;
	font-size: 50px;
  }

  .bg-grey {
      background-color: #f6f6f6;
  }

  .logo-small {
      color: #f4511e;
      font-size: 50px;
  }

  .logo {
      color: #f4511e;
      font-size: 200px;
  }
 
  .item h4 {
      font-size: 19px;
      line-height: 1.375em;
      font-weight: 400;
      font-style: italic;
      margin: 70px 0;
  }
  .item span {
      font-style: normal;
  }

  </style>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
	<span class="icon-bar"></span>
	<span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage">Money</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
	<li><a href="#Introduce">Introduce</a></li>
	<li><a href="#Profile">Expense</a></li>
	<li><a href="#Mileage">Mileage</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="jumbotron text-center">
  <h1>MoneyBook</h1> 
  <p>if you want to get source,press <a href="https://github.com/tamia7011/JavaMoneyBook">Github Repository</a> </p>

</div>

<div id="Introduce" class="container-fluid">
  <div class="row">
    <div class="col-sm-8">
      <h2>INTRODUCE MONEYBOOK</h2><br>
	<h4>Team 3's moneybook is very comfortable. we're moneybook
            have variable option. Also, sign in moneybook and compare
            mileage other members. And we can see graph that we earn
            money or we spend money. We can learn how to manage money
            through this moneybook.  </h4> 
    </div>
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-book logo"></span>
    </div>
  </div>
</div>

<div id="Profile" class="container-fluid bg-grey">
  <div class="row">
    <div class="col-sm-4">
      <span class="glyphicon glyphicon-folder-open logo slideanim" onclick = "location.href='expense.php'"></span>
    </div>
    <div class="col-sm-8">
      <h1>Expense</h1><br>
      <h4><strong>EXPENSE:</strong> Family users can conveniently enter the web 
                  in the web by entering the fi - fixer, flexible, and waste costs.
                   You can also see a graph at a glance through the input.</h4><br>
    </div>
  </div>
</div>

<div id="Mileage" class="container-fluid bg-grey">
  <div class="row">
	<div class="col-sm-4">
	        
	<button class="btn btn-default" type="button" onclick="location.href='compare.php'" id="sign-in">compare</button>
        <span class="glyphicon glyphicon-phone logo slideanim" onclick="location.href='mileage.php'"></span>
   	</div>
  <div class="consol-sm-8">
  <h1>Mileage</h1><br>
  <h4><strong>Compare other users:</strong> Compared to other users, I can check
              the status of money for a month by comparing mileages with others.
              If you manage to manage your money bettter than others, you can
              manage money in the future, and if you don't manage to manage it,
	      it will help you decide if you spend money.</h4><br>
  </div>
  </div>
</div>

</script>
</body>
</html>
