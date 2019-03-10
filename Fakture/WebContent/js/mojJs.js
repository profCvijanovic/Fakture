/**
 * 
 */
function userRegistrationValidation() {
	// elementi iz inputa
	var email = document.getElementById('inputEmail');
	var password = document.getElementById('inputPassword');
	var repeatedPassword = document.getElementById('inputPassword2');
	var name = document.getElementById('imeUsera');
	var lastName = document.getElementById('prezimeUsera');
	var kontaktTelefon = document.getElementById('kontaktTelefon');
	
	// error elementi
	var emailErr = document.getElementById('emailErr');
	var passwordErr = document.getElementById('passwordErr');
	var repeatedPasswordErr = document.getElementById('repeatedPasswordErr');
	var nameErr = document.getElementById('nameErr');
	var lastNameErr = document.getElementById('lastNameErr');
	var telefonErr = document.getElementById('telefonErr');
	
	// uslovi za prazno polje
	if (email.value == "") {
		email.style.border = "2px solid #ff0000";
		emailErr.textContent = "Morate uneti email";
		email.focus();
		return false;
	} else {
		email.style.border = "2px solid blue";
		emailErr.textContent = "";
	}
	if (password.value == "") {
		password.style.border = "2px solid #ff0000";
		passwordErr.textContent = "Morate uneti password";
		password.focus();
		return false;
	} else {
		password.style.border = "2px solid blue";
		passwordErr.textContent = "";
	}

	if (repeatedPassword.value == "") {
		repeatedPassword.style.border = "2px solid #ff0000";
		repeatedPasswordErr.textContent = "Morate ponovo uneti password";
		repeatedPassword.focus();
		return false;
	} else {
		repeatedPassword.style.border = "2px solid blue";
		repeatedPasswordErr.textContent = "";
	}
		
		if (name.value == "") {
		name.style.border = "2px solid #ff0000";
		nameErr.textContent = "Morate uneti ime";
		name.focus();
		return false;
	} else {
		name.style.border = "2px solid blue";
		nameErr.textContent = "";
	}	
		if (lastName.value == "") {	
		lastName.style.border = "2px solid #ff0000";
		lastNameErr.textContent = "Morate uneti prezime";
		lastName.focus();
		return false;
	} else {
		lastName.style.border = "2px solid blue";
		lastNameErr.textContent = "";
	}
		if (kontaktTelefon.value == "") {
			kontaktTelefon.style.border = "2px solid #ff0000";
			kontaktTelefon.textContent = "Morate uneti ime firme";
			kontaktTelefon.focus();
		return false;
	} else{
		kontaktTelefon.style.border = "2px solid blue";
		telefonErr.textContent = "";
	} 
		
		
		// uslov za password
		if (password.value != repeatedPassword.value) {	
		password.style.border = "3px solid  #cc0099";
		repeatedPassword.style.border = "3px solid  #cc0099";
		passwordErr.innerHTML = "Nisu isti password-i";
		return false;
	} 
}
		
function loginValidation() {
	
	// elementi iz inputa
	var email = document.getElementById('inputEmail');
	var password = document.getElementById('inputPassword');
	var check = document.getElementById('check');

	// error elementi
	var emailErr = document.getElementById('emailErr');
	var passwordErr = document.getElementById('passwordErr');
	var checkErr = document.getElementById('checkErr');
	
	// uslovi za prazno polje
		if (email.value == "") {
			email.style.border = "2px solid #ff0000";
			emailErr.textContent = "Morate uneti email";
			email.focus();
			return false;
		} else {
			email.style.border = "2px solid blue";
			emailErr.textContent = "";
		}
		if (password.value == "") {
			password.style.border = "2px solid #ff0000";
			passwordErr.textContent = "Morate uneti password";
			password.focus();
			return false;
		} else {
			password.style.border = "2px solid blue";
			passwordErr.textContent = "";
		}
		if (check.checked == false) {
			checkErr.textContent = "obavezan check in";
			return false;
		} else {
			checkErr.textContent = "";
		}		
} 	


function prikaziTabelu(){
	
	var tabela = document.getElementById('tabelaUsera');
	
	  if (tabela.style.display == "none") {
		  tabela.style.display = "block";
		  } else {
			  tabela.style.display = "none";
		  }
}
			
function firmaRegistrationValidation() {
	// elementi iz inputa

	var firma = document.getElementById('imeFirme');
	var pib = document.getElementById('PIB');
	var maticniBroj = document.getElementById('maticniBroj');
	var drzava = document.getElementById('drzava');
	var grad = document.getElementById('grad');
	var ulica = document.getElementById('ulica');
	var postanskiBroj = document.getElementById('postanskiBroj');

	// error elementi

	var firmaErr = document.getElementById('firmaErr');
	var pibErr = document.getElementById('pibErr');
	var maticniErr = document.getElementById('maticniErr');
	var drzavaErr = document.getElementById('drzavaErr');
	var gradErr = document.getElementById('gradErr');
	var ulicaErr = document.getElementById('ulicaErr');
	var postanskiBrojErr = document.getElementById('postanskiBrojErr');
	// uslovi za prazno polje
	
		if (firma.value == "") {
		firma.style.border = "2px solid #ff0000";
		firmaErr.textContent = "Morate uneti ime firme";
		firma.focus();
		return false;
	} else{
		firma.style.border = "2px solid blue";
		firmaErr.textContent = "";
	} 
		if (pib.value == "") {
		pib.style.border = "2px solid #ff0000";
		pibErr.textContent = "Morate uneti pib"
		pib.focus();
		return false;
	} else{
		pib.style.border = "2px solid blue";
		pibErr.textContent = ""
	}
		if (maticniBroj.value == "") {
		maticniBroj.style.border = "2px solid #ff0000";
		maticniErr.textContent = "Morate uneti maticni broj firme";
		maticniBroj.focus();
		return false;
	} else {
		maticniBroj.style.border = "2px solid blue";
		maticniErr.textContent = "";
	}
		if (drzava.value == "") {
			drzava.style.border = "2px solid #ff0000";
			drzavaErr.textContent = "Morate uneti ime drzave";
			drzava.focus();
			return false;
		} else {
			drzava.style.border = "2px solid blue";
			drzavaErr.textContent = "";
		}
		if (grad.value == "") {
			grad.style.border = "2px solid #ff0000";
			gradErr.textContent = "Morate uneti ime grada";
			grad.focus();
			return false;
		} else {
			grad.style.border = "2px solid blue";
			gradErr.textContent = "";
		}
		if (ulica.value == "") {
			ulica.style.border = "2px solid #ff0000";
			ulicaErr.textContent = "Morate uneti ime ulice";
			ulica.focus();
			return false;
		} else {
			ulica.style.border = "2px solid blue";
			ulicaErr.textContent = "";
		}
		
		if (postanskiBroj.value == "") {
			postanskiBroj.style.border = "2px solid #ff0000";
			postanskiBrojErr.textContent = "Morate uneti postanski broj";
			postanskiBroj.focus();
			return false;
		} else {
			postanskiBroj.style.border = "2px solid blue";
			postanskiBrojErr.textContent = "";
		}
		
}
		
