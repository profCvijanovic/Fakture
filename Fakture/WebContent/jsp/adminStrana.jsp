<%@page import="model.ZiroRacun"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ page import="model.ZiroRacun" %>
<%@ page import="model.Firma" %>
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
		  href = "../css/style.css"  
	/>
<title>admin strana</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //Sprecavam back da se vrati prilikom logout-a za HTTP 1.1
		response.setHeader("Pragma","no-cache");//Sprecavam back da se vrati prilikom logout-a za HTTP 1.0
		response.setHeader("Expires", "0");
	%>
	<div class="container-fluid">
		<div class="row"><!-- div header -->
			<div class="col-12"><!-- div navbar -->
				nav bar ovde
			</div><!-- kraj div navbar -->
			<div><!-- log out -->
				<form method = "get" action = "../LogoutServlet">
					<input type="submit" value = "Logout">
				</form>
			</div><!-- kraj log out -->
		</div><!-- kraj div header -->
		<div class="row"><!-- Sredina div -->
			<div class="col-4"><!-- div sredina levo -->
				
				<button type="button" class="btn btn-primary" onclick="prikaziTabelu()">
					Prikazi/Sakrij sve usere
				</button><!-- dugme prikazi/sakrij tabelu -->
				<br> 
				<br>
				
				<p>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">
						Azuriraj</button>
				</p>
				<div class="collapse" id="collapseExample"><!-- pocetak collapse-a izmena -->
					<div class="card card-body">
						<form method="get" action="../IzmenaServlet">
							<div class="form-row align-items-center">
								<div class="col-auto">
									<label for="inlineFormInput">mail usera</label> 
									<input
										type="text" class="form-control mb-2" id="inlineFormInput"
										name="email">
								</div>
								<div class="col-auto my-1">
									<label for="inlineFormCustomSelect">sta zelite da azurirate</label> 
									<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="izaberi">
										<option selected>Izaberite...</option>
										<option value="userName">E-mail</option>
										<option value="password">Password</option>
										<option value="imeUsera">Ime klijenta</option>
										<option value="prezimeUsera">Prezime klijenta</option>
										<option value="imeFirme">Ime firme</option>
										<option value="pib">PIB</option>
										<option value="maticniBrojFirme">Maticni broj firme</option>
										<option value="drzava">Drzava</option>
										<option value="grad">Grad</option>
										<option value="ulica">Ulica</option>
										<option value="postanskiBroj">Postanski broj</option>
									</select>
								</div>
								<div class="col-auto">
									<label for="inlineFormInput2">upisite izmenu</label> 
									<input type="text" class="form-control mb-2" id="inlineFormInput2" name="promena">
								</div>
								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-2">Azuriraj</button>
								</div>
							</div>
						</form>
					</div>
				</div><!-- Ovde je kraj collapse-a izmena-->
				<br> 
				<br>
				
				<p>
					<button class="btn btn-primary" type="button"
						data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">
						Aktiviraj Usera
					</button>
				</p>
				<div class="collapse" id="collapseExample"><!-- pocetak collapse-a Aktiviraj usera -->
					<div class="card card-body">
						<form method="get" action="../AktivirajUseraServlet">
							<div class="form-row align-items-center">
								<div class="col-auto">
									<label for="inlineFormInput">mail usera</label> 
									<input type="text" class="form-control mb-2" id="inlineFormInput" name="email">
								</div>
								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-2">Aktiviraj Usera</button>
								</div>
							</div>
						</form>
					</div>
				</div><!-- Ovde je kraj collapse-a Aktiviraj usera-->
			</div><!-- kraj div sredina levo -->
			
			<div class="col-8"><!-- div sredina desno -->
				<%
		
					User user = (User) session.getAttribute("user");
				%>
				<h1>
					Dobro dosli admin
					${user.userName}
				</h1>
				<%
					AdminMetode admin = new AdminMetode();
					List<User> users = admin.vratiSveUsere();
				
				%>
				<div id="tabelaUsera"> <!-- Pocetak tabela div-a -->
					<table class="table">
						<thead>
							<tr>
								<th scope="col">id</th>
								<th scope="col">User Name</th>
								<th scope="col">Password</th>
								<th scope="col">Ime usera</th>
								<th scope="col">Prezime usera</th>
								<th scope="col">Aktivan</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (User u : users) {
							%>
							<tr>
								<th scope="row"><%=u.getUserId()%></th>
								<td><%=u.getUserName()%></td>
								<td><%=u.getPassword()%></td>
								<td><%=u.getImeUsera()%></td>
								<td><%=u.getPrezimeUsera()%></td>
								<td><%=u.isAktivanUser()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<!-- Ovde je kraj tabela diva -->
			</div>
			<!-- kraj div sredina desno -->
		</div>
		<!-- kraj sredina div -->
		<div class="row"><!-- div footer -->
			<div class="col-12"><!-- div futer sadrzaj -->
				footer
			</div><!-- kraj div futer sadrzaj -->
		</div><!-- kraj div footer -->
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