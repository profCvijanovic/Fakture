/**
 * 
 */
function registrationValidation(){
	//elementi iz inputa
	var email = document.getElementById('inputEmail');
	var password = document.getElementById('inputPassword');
	var repeatedPassword = document.getElementById('inputPassword2');
	var name = document.getElementById('imeUsera');
	var lastName = document.getElementById('prezimeUsera');
	var firma = document.getElementById('imeFirme');
	var pib = document.getElementById('PIB');
	var maticniBroj = document.getElementById('maticniBroj');
	
	//error elementi
	var emailErr = document.getElementById('emailErr');
	var passwordErr = document.getElementById('passwordErr');
	var repeatedPasswordErr = document.getElementById('repeatedPasswordErr');
	var nameErr = document.getElementById('nameErr');
	var lastNameErr = document.getElementById('lastNameErr');
	var firmaErr = document.getElementById('firmaErr');
	var pibErr = document.getElementById('pibErr');
	var maticniErr = document.getElementById('maticniErr');
	
	//dodaj event listenere
	email.addEventListener("blur",emailVerify,true);
	password.addEventListener("blur",passwordVerify,true);
	repeatedPassword.addEventListener("blur",repeatedPasswordVerify,true);
	name.addEventListener("blur",nameVerify,true);
	lastName.addEventListener("blur",lastNameVerify,true);
	firma.addEventListener("blur",firmaVerify,true);
	pib.addEventListener("blur",pibVerify,true);
	maticniBroj.addEventListener("blur",maticniBrojVerify,true);

	//uslovi za prazno polje
	if(email.value == ""){
		email.style.border = "2px solid #ff0000";
		emailErr.textContent = "Morate uneti email!"
		email.focus();
		return false;
	}
	if(password.value == ""){
		password.style.border = "2px solid #ff0000";
		passwordErr.textContent = "Morate uneti password!"
			password.focus();
		return false;
	}
	if(repeatedPassword.value == ""){
		repeatedPassword.style.border = "2px solid #ff0000";
		repeatedPasswordErr.textContent = "Morate ponovo uneti password!"
		repeatedPassword.focus();
		return false;
	}
	if(name.value == ""){
		name.style.border = "2px solid #ff0000";
		nameErr.textContent = "Morate uneti ime!"
		//name.focus();
		return false;
	}
	if(lastName.value == ""){
		lastName.style.border = "2px solid #ff0000";
		lastNameErr.textContent = "Morate uneti prezime!"
		lastName.focus();
		return false;
	}
	if(firma.value == ""){
		firma.style.border = "2px solid #ff0000";
		firmaErr.textContent = "Morate uneti ime firme!"
		firma.focus();
		return false;
	}
	if(pib.value == ""){
		pib.style.border = "2px solid #ff0000";
		pibErr.textContent = "Morate uneti pib!"
		pib.focus();
		return false;
	}
	if(maticniBroj.value == ""){
		maticniBroj.style.border = "2px solid #ff0000";
		maticniErr.textContent = "Morate uneti maticni broj firme!"
		maticniBroj.focus();
		return false;
	}
	
	//provera da li su isti passwordi
	if(password.value != repeatedPassword.value){
		password.style.border = "3px solid  #cc0099";
		repeatedPassword.style.border = "3px solid  #cc0099";
		passwordErr.innerHTML = "Nisu isti password-i!"
		return false;
	}
}

function emailVerify(){
	email.style.border = "1px solid #0000ff";
	emailErr.innerHTML = ""
	return true;	
}

function passwordVerify(){
	password.style.border = "1px solid #0000ff";
	passwordErr.innerHTML = ""
	return true;	
}

function repeatedPasswordVerify(){
	repeatedPassword.style.border = "1px solid #0000ff";
	repeatedPasswordErr.innerHTML = ""
	return true;	
}

function nameVerify(){
	name.style.border = "1px solid #0000ff";
	nameErr.innerHTML = ""
	return true;	
}

function lastNameVerify(){
	lastName.style.border = "1px solid #0000ff";
	lastNameErr.innerHTML = ""
	return true;	
}

function firmaVerify(){
	firma.style.border = "1px solid #0000ff";
	firmaErr.innerHTML = ""
	return true;	
}

function pibVerify(){
	pib.style.border = "1px solid #0000ff";
	pibErr.innerHTML = ""
	return true;	
}

function maticniBrojVerify(){
	maticniBroj.style.border = "1px solid #0000ff";
	maticniErr.innerHTML = ""
	return true;	
}
