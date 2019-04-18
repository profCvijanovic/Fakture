<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<!-- Moj CSS -->	
	<link rel  = "stylesheet"
		  type = "text/css"
		  href = "../css/style.css"  
	/>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

	<div class="container-fluid">
	<h1>Log in</h1>
	<a href = "../index.html">back</a>
	  <div class="row">
	   	<div class="col-3">
 		
 		</div>
	    <div class="col-6">
	      <div id = "registrationFormDiv" >
			<form method="post" action="../LoginServlet" onsubmit="return loginValidation();">
			  <div class="form-group">
			    <label class = "sivaSlova" for="inputEmail">Email address</label>
			    <input type="email" class="form-control sirinaPoljaForme" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email" name = "userName">
			  </div>
			  <div id = "emailErr"></div>
			  <div class="form-group">
			    <label class = "sivaSlova" for="inputPassword">Password</label>
			    <input type="password" class="form-control sirinaPoljaForme" id="inputPassword" placeholder="Password" name = "password">
			  </div>
			  <div id = "passwordErr"></div>
			  <div class="form-group form-check">
			    <input type="checkbox" class="form-check-input" id="check" name = "check">
			    <label class="form-check-label sivaSlova" for="check">Nisam robot</label>
			  </div>
			  <div id = "checkErr"></div>
			  <div class="form-group form-check">
			  <button type="submit" class="btn btn-primary">login</button>
			</form>
			</div></div><!-- Ovde je kraj forma diva -->
 		 </div>
 		 <div class="col-3">
 	
 		 </div>
	</div>	
	
	

</div><!-- Ovde je kraj container-fluida -->
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
<!-- Moj JavaScript -->   
	<script type="text/javascript" src = "../js/mojJs.js"></script>
</body>
</html>