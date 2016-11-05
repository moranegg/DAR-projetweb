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
			var email = $('#email_register').val();
			var password = $('#password_register').val();
			var nom = $('#nom').val();
			var prenom = $('#prenom').val();
			var codep = $('#codep').val();

			updateProfil(nom,prenom,codep,email, password);

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
				//alert ("coucou1"+resultat);
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
				alert("updated!");
				routeur.account(data.id_user);
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			alert("status: " + XHR.status + ", erreur: " + XHR.responseText);
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
			//var resultat = $.parseJSON(data);
			var resultat = data;
			if (resultat.message==1)
			{
				var musees = resultat.musee;
				var eltDomList = "#liste_fav";
				if(musees.length == 0)
				{
					$("#liste_fav").append('<li class="list-group-item info" >La liste des favoris est vide</li>');
				} 
				else 
				{
					afficheMusee(musees, eltDomList);
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

