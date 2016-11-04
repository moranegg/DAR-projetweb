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
			if(this.idUser != undefined){
				var profil = readUserServer(this.idUser);
				showprofil (profil);
			}else{
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
			//var musees = readFavoris();
			
			//test local
			var musees = testRechercheMusee().musees;
			var eltDomList = "#liste_fav";
			if(musees == undefined){
				$("#liste_fav").append('<li class="list-group-item info" >La liste des favoris est vide</li>');
			} else {
				afficheMusee(musees, eltDomList);
			}
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
				return resultat;
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

	console.log(resultat.nom);
	var input = $("#nom");
	input.val(input.val() + resultat.nom);

	var input = $("#prenom");
	input.val(input.val() + resultat.prenom);

	var input = $("#codep");
	input.val(input.val() + resultat.codep);

	var input = $("#email_register");
	input.val(input.val() + resultat.email);


}
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
				return musees;
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

