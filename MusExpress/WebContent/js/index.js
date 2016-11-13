$( document ).ready(function(){

	$("#login-btn").click(index.login);
	$("#register-btn").click(index.createAccount);
});
/**
 * object Index for actions on index
 */
var index = {

		onReady: function() {
		},
		login: function(event){
			hideDom('#login-btn')
			hideDom("#notifier-login");
			showDom('#loader-login');
			
			var email = $('#email_login').val();
			var password = $('#password_login').val();
			if(checkIsText(email)&& checkIsText(password) && isEmail(email)){
				console.log("form checked")
				login(email,password);
			}else{
				resetForm('#loader-login','#login-btn');
				printhtml("#notifier-login","champs non rempli");
				console.log("form not checked")
			}
		},
		createAccount: function(event){
			hideDom('#register-btn')
			hideDom("#notifier-register");
			showDom('#loader-register');
			
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
				resetForm('#loader-register','#register-btn');
				console.log("method verif retourne faux, champs non ou " +
				"mal remplis");
				//alert("problème !! ")
			}

		}
};

/**
 * Verifications du formulaire inscription
 * @param nom
 * @param prenom
 * @param codep
 * @param email
 * @param password
 * @returns {Boolean}
 */
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
/**
 * sends ajax to LoginServlet
 * @param email
 * @param password
 */
function login(email,password){
	console.log("send to LoginServlet");
	$.ajax({
		type : "GET",
		url : "LoginServlet",
		data :{
			"email":email,
			"password":password,
		},

		dataType : "json",
		success : function(data) { 
			//console.log("success from LoginServlet");
		//var resultat = $.parseJSON(data);
		//var resultat = JSON.parse(JSON.stringify(data));
		var resultat=data;

		var user = resultat.user;
		//console.log("resultat.message: "+resultat.message);
		if (resultat.message=="1") 		
		{
			//console.log("resultat.idUser: "+resultat.id_user)
            routeur.home(resultat.id_user);
		} else{
			printhtml('#notifier-login',"Mauvais mail ou mot de passe");
			resetForm('#loader-login','#login-btn');
		}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			//console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
			printhtml('#notifier-login',"erreur de connexion au serveur");
			resetForm('#loader-login','#login-btn');
		}
	});
}
/**
 * sends ajax to server-InscriptionServlet
 * @param prenom
 * @param nom
 * @param codep
 * @param email
 * @param password
 */
function enregistre(prenom, nom, codep, email, password) 
{
	console.log("send to InscriptionServlet");
	$.ajax({
		type : "GET",
		url : "InscriptionServlet",
		data :{
			"prenom": prenom,
			"nom": nom,
			"codep":codep,
			"email":email,
			"password":password,
		},

		dataType : "json",
		success : function(data) { 
			console.log("success from InscriptionServlet");
			//var resultat = $.parseJSON(data);
		    var resultat = data;
			var user = resultat.id_user;
			
			console.log("resultat.message: "+resultat.message)
			console.log("resultat.id_user: "+resultat.id_user)
			if(resultat.message==1){
				routeur.home(resultat.id_user);
			}else{
				resetForm('#loader-register','#register-btn');
				console.log("else.resultat.message: "+resultat.message);
				printhtml('#notifier-register',"Email existant dans la BDD, veuillez choisir un autre mail");
			}
			
			
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			resetForm('#loader-register','#register-btn');
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

