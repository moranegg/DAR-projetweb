$( document ).ready(function(){
	displayTime();
	account.readUser();
	account.readFavoris();
	$("#update-btn").click(account.updateUser);		
});

var account = {
		idUser: '',

		readUser: function(){
			console.log("account.readUser");
			//appel au serveur avec id_user
			this.idUser = GetURLParameter('id_user');
			console.log('idUser :'+this.idUser)
			if(this.idUser != undefined)
			{
				//var profil = readUserServer(this.idUser);
				//showprofil (profil);
				readUserServer(this.idUser);
			}
			else
			{
				//problème d'id
				alert("Le profil n'est pas reconnu");
				//rerouter vers index
				//routeur.index();
			}

		},
		updateUser: function()
		{
			hideDom('#update-btn')
			hideDom("#notifier-update");
			showDom('#loader-update');
			
			var email = $('#email_register').val();
			var password = $('#password_register').val();
			var nom = $('#nom').val();
			var prenom = $('#prenom').val();
			var codep = $('#codep').val();
			
			
			var ok = verif(nom, prenom, codep, email, password);
			if (ok) {
				console.log("ok");
				updateProfil(nom,prenom,codep,email, password);
			}else{
				resetForm('#loader-update','#update-btn');
				console.log("method verif retourne faux, champs non ou " +
				"mal remplis");
			}
			

		},
		readFavoris: function(){

			console.log("account.readFavoris");
			//appel au serveur
			var musees = readFavoris();

			//test local
			//var musees = testRechercheMusee().musees;

//			var eltDomList = "#liste_fav";
//			if(musees == undefined){
//			$("#liste_fav").append('<li class="list-group-item info" >La liste des favoris est vide</li>');
//			} else {
//			afficheMusee(musees, eltDomList);
//			}
		}
}
function readUserServer(idU){
	//readUser avec UserServlet/AccountServlet dans l'approche REST
	//ou ReadUserServlet dans l'approche SOAP
	$.ajax({
		type: "GET",
		url : "ConsulterUserServlet",
		dataType : 'json',
		data : {
			id_user : idU
		},
		success : function(data) {

			var resultat = data;
			if (resultat.message==1)
			{
				showprofil (resultat);
				//return resultat;
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

function showprofil (resultat)
{
	//la fonction fillInput prend un element DOM et met le deuxième param en  valeur
	fillInput("#nom",resultat.nom);


	fillInput("#prenom",resultat.prenom);


	fillInput("#codep", resultat.codep);


	fillInput("#email_register",resultat.email);

}
/**
 * la fonction fillInput prend un element DOM et met le deuxième param en  valeur
 * @param eltDomInput
 * @param text
 */
function fillInput(eltDomInput, text){
	var input = $(eltDomInput);
	input.val(text);
}
/**
 * envoi au serveur les données pour updateProfil modifiées
 * @param nom
 * @param prenom
 * @param codep
 * @param email
 * @param password
 */
function updateProfil(nom,prenom,codep,email, password){
	$.ajax({
		type : "GET",
		url : "UpdateUserServlet",
		data : {
			"id": GetURLParameter('id_user'),
			"prenom" : prenom,
			"nom" : nom,
			"codep" : codep, 
			"email": email,
			"password": password,

		},


		dataType : "json",
		success : function(data)
		{
			if (data.message==1)
			{
				resetForm('#loader-update','#update-btn');
				console.log("update success: "+data.message);
				printhtml('#notifier-update',"Votre compte à bien été modifier");
				//routeur.account(data.id_user);
			} else {
				resetForm('#loader-update','#update-btn');
				console.log("update error: "+data.message);
				printhtml('#notifier-update',"Mot de passe incorrect, la modification n'a pas été prise en compte");
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			resetForm('#loader-update','#update-btn');
			console.log("update error: "+errorThrown);
			printhtml('#notifier-update',"Erreur sur le serveur");
		}
	});
}
function readFavoris(){
	//favoris par FavorisSerrvlet
	$.ajax({
		type: "GET",
		url : "AfficherFavorisServlet",
		data : {
			id_user:GetURLParameter('id_user'), 
		},
		dataType : 'json',

		success : function(data) {
			if (data.message==1)
			{
				var musees = data.musees;
				var eltDomList = "#liste_fav";
				if(musees.length == 0)
				{
					$("#liste_fav").append('<li class="list-group-item info" >La liste des favoris est vide</li>');
				} 
				else 
				{
					afficheMuseeRecherche(musees, eltDomList);
				}
				//return musees;
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

function verif(nom, prenom, codep, email, password) 
{

	if(prenom.length==0)
	{

		printhtml('#notifier-update',"Prenom manquant");
		return false;
	}

	if(nom.length==0)
	{
		printhtml('#notifier-update',"Nom manquant");
		return false;
	}

	if(codep.length<5)
	{
		printhtml('#notifier-update',"Code postal manquant");
		return false;
	}

	if(email.length==0 && !isEmail(email))
	{
		printhtml('#notifier-update',"Email manquant");
		return false;
	}

	if(password.length<8)
	{
		printhtml('#notifier-update',"Vous devez renseigner votre mot de passe afin de modifier votre compte");
		return false;
	}



	return true;
}


