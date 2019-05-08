<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ page import="model.Firma" %>
<%@ page import="java.util.List" %>
<%@ page import="bussinesService.UserMetode" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>firma</title>
</head>
<body>
	<div class="container-fluid">
		<% User user = (User)session.getAttribute("user");
		%>
		<h1>Dodajte firmu</h1>
		
		<a href = "userStrana.jsp">home</a>
		
		<form action = "../DodajFirmuServlet">
		  <fieldset>
		    <legend>Dodajte firmu:</legend>
			    <input type="text" placeholder = "Ime firme" name = "imeFirme"><br>
			    <input type="text" placeholder = "PIB" name = "pib"><br>
			    <input type="text" placeholder = "Maticni broj firme" name = "maticniBrojFirme"><br>
			    <input type="text" placeholder = "Drzava" name = "drzava"><br>
			    <input type="text" placeholder = "Grad" name = "grad"><br>
			    <input type="text" placeholder = "Ulica" name = "ulica"><br>
			    <input type="text" placeholder = "Postanski broj" name = "postanskiBroj"><br>
			    <input type="submit" value = "Dodaj firmu">
		  </fieldset>
		</form>
		
		
		
		
		
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