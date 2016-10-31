var index = {

		onReady: function() {
		},


		login: function(event){
			//event.preventDefault();
			var email = $('#email_login').val();
			var password = $('#password_login').val();
			if(checkIsText(email)&& checkIsText(password) && isEmail(email)){
				console.log("serveur")
				login(email,password);
			}else{
				printhtml("#notifier-login","champs non rempli");
				console.log("problème !!")
			}

		},

		createAccount: function(event){
			//alert("account");
			var email = $('#email_register').val();
			var password = $('#password_register').val();
			var nom = $('#nom').val();
			var prenom = $('#prenom').val();
			var codep = $('#codep').val();


			var ok = verif(nom, prenom, codep, email, password);
			if (ok) {
				console.log("ok");
				enregistre(nom, prenom, codep, email, password);
			}else{
				console.log("method verif retourne faux, champs non ou " +
						"mal remplis");
				//alert("problème !! ")
			}

		}

};

$( document ).ready(function(){

	$("#login-btn").click(index.login);
	$("#register-btn").click(index.createAccount);


});


function verif(nom, prenom, codep, email, password) 
{

	if(prenom.length==0)
	{

		printhtml('#notifier-register',"Prenom manquant");
		return false;
	}

	if(nom.length==0)
	{
		printhtml('#notifier-register',"Nom manquant");
		return false;
	}

	if(codep.length<5)
	{
		printhtml('#notifier-register',"Code postal manquant");
		return false;
	}

	if(email.length==0 && !isEmail(email))
	{
		printhtml('#notifier-register',"Email manquant");
		return false;
	}

	if(password.length==0)
	{
		printhtml('#notifier-register',"Mot de passe manquant");
		return false;
	}

	if(password.length<8)
	{
		printhtml('#notifier-register',"Mot de passe trop court");
		return false;
	}

	return true;
}
function login(email,password){
	$.ajax({
		type : "POST",
		url : "LoginServlet",
		data :{
			"email":email,
			"password":password,
		},

		dataType : "json",
		success : function(data) { 
			var resultat = $.parseJSON(data);
			var user = resultat.user;
			if (resultat.message=="1") 		
			{
				console.log("success")
				//TODO: ajouter id utilisateur au path
				$(location).attr('templates/home.html?id_user='+user); 
				//$(location).attr('home.html/'+user); 
			} 
		},
		error : function(request,error) 
		{
			// alert("Erreur : responseText: "+request.responseText);
			$(location).attr('/home.html?id_user='); 
		}
	});
}

function checkIsText(text){
	if(text.length==0)
	{
		return false;
	}else{
		return true;
	}
}
function isEmail(email){

	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);

}


function enregistre(prenom, nom, codep, email, password) 
{
	$.ajax({
		type : "POST",
		url : "InscriptionServlet",
		data :{
			"prenom": prenom,
			"nom": nom,
			"codep":codep,
			"mail":email,
			"password":password,
		},

		dataType : "json",
		success : function(data) { 
			alert(data.responseText);  
		},
		error : function(request,error) 
		{
			 alert("Erreur : responseText: "+request.responseText);
		}
	});
}

function traiteReponseEnregistrement(rep) 
{
	if (rep.error != undefined)  
	{
		func_erreur_inscription(rep.error);
	}
	else if (rep.message!=undefined)
	{
		if (rep.message!="1") func_erreur_inscription(rep.message);
		else {
			//$(location).attr('home.html'); 
		}
	}
	else 
	{
		$(location).attr('home.html'); 
	}
}


function printhtml(dom,msg)
{
	$(dom).html(msg);
	$(dom).removeClass('hide');
}


function traiteResponse(){

}
