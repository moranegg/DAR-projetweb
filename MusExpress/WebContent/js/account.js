$( document ).ready(function(){
	displayTime();
	readUser();
	readFavoris();
	$("#update-btn").click(account.updateUser);		
});

var account = {
		readUser: function(){

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

		}
}
function readUser(){
	//readUser avec UserServlet/AccountServlet dans l'approche REST
	//ou ReadUserServlet dans l'approche SOAP
	$.ajax({
		type: "GET",
		url : "ConsulterUserServlet",
		dataType : 'json',
		data : {
			id_user : GetURLParameter('id_user')
		},
		success : function(data) {

			var resultat = data;
			if (resultat.message==1)
			{

				showprofil(resultat);

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
				//afficheMusee(musees);
				if (musees.length!=0)
				{
					//alert ("coucou");
					afficheMusee(musees);

				}
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

function afficheMusee(musees){
	//ajout de div dans la liste des musee
	for(i=0; i<musees.length; i++)
	{
		$("#liste_fav").append('<li class="list-group-item">'+musees[i].nom+'</li>');
		//console.log(musees[i].nom);

	}
}