<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ page import="bussinesService.AdminMetode" %>
<%@ page import="java.util.List" %>
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
		  href = "css/style.css"  
	/>
<title>admin strana</title>
</head>
<body>
	<div class="container-fluid">
		
		<% User user = (User)request.getAttribute("user");
		   session.setAttribute("user", user);
		%>
		<h1>
			Dobro dosli admin
			<%=user.getUserName()%>
		</h1>

		<div class="row">
			<div class="col-4">
				<button type="button" class="btn btn-primary" onclick="prikaziTabelu()">Prikazi/Sakrij sve usere</button>
			</div><!-- Ovde je kraj levog diva -->
			<div class="col-8">
				<% AdminMetode admin = new AdminMetode();
				   List<User> users = admin.vratiSveUsere(); 
				%>
				<div id="tabelaUsera">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">User Name</th>
							<th scope="col">Password</th>
							<th scope="col">Ime usera</th>
							<th scope="col">Prezime usera</th>
							<th scope="col">Ime firme</th>
							<th scope="col">PIB</th>
							<th scope="col">Maticni broj firme</th>
							<th scope="col">Drzava</th>
							<th scope="col">Grad</th>
							<th scope="col">Ulica</th>
							<th scope="col">Postanski broj</th>
											
						</tr>
					</thead>
					<tbody>
						<%for(User u:users){
							
						%>
						<tr>
							<th scope="row"><%=u.getUserId() %></th>
							<td><%=u.getUserName() %></td>
							<td><%=u.getPassword() %></td>
							<td><%=u.getImeUsera() %></td>
							<td><%=u.getPrezimeUsera() %></td>
							<td><%=u.getImeFirme() %></td>
							<td><%=u.getPIB() %></td>
							<td><%=u.getMaticniBrojFirme() %></td>
							<td><%=u.getAdresa().getDrzava() %></td>
							<td><%=u.getAdresa().getGrad() %></td>
							<td><%=u.getAdresa().getUlica() %></td>
							<td><%=u.getAdresa().getPostanskiBroj() %></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div><!-- Ovde je kraj tabela diva -->	
			</div><!-- Ovde je kraj desnog diva -->
		</div><!-- Ovde je kraj row diva -->

	</div><!-- Ovde je kraj container-fluida -->
	<!-- Optional JavaScript -->
	    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<!-- Moj JavaScript -->   
		<script type="text/javascript" src = "js/mojJs.js"></script>	
</body>
</html>