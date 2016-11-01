$( document ).ready(function(){
		displayTime();
		readUser();
		readFavoris();
		$("#update-btn").click(account.updateUser);		
	});

var account = {
		readUser: function(){
			
		},
		updateUser: function(){
			
		},
		readFavoris: function(){
			
		}
}
function readUser(){
	//readUser avec UserServlet/AccountServlet dans l'approche REST
	//ou ReadUserServlet dans l'approche SOAP
	$.ajax({
		type: "POST",
        url : "../ConsulterUserServlet",
        dataType : 'json',
        data : {id : "1"},
        success : function(data) {
        	
        	var resultat = $.parseJSON(data);
        	//alert(resultat);
//			var nom = resultat.nom;
//			var prenom = resultat.prenom;
//			var codep = resultat.codep;
//			var email = resultat.email;
			//var photo = ...
        	$("#nom").append(resultat.nom);
        	$("#prenom").append(resultat.prenom);
        	$("#codep").append(resultat.codep);
        	$("#email_register").append(resultat.email);
			
        },
        error : function(XHR, testStatus, errorThrown) 
		{
        	 alert("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
    });
}
function updateUser(id, nom,prenom,codep,email, password){
	$.ajax({
		type : "POST",
		url : "../UpdateUserServlet",
		data : {
			"id": id,
			"prenom" : prenom,
			"nom" : nom,
			"codep" : codep, 
			"email": email,
		},
				
		dataType : "json",
		success : function(){
			alert("updated!");
			
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
		type: "POST",
        url : "../AfficherFavorisServlet",
        data : {
        	id:"1", 
        },
        dataType : 'json',

        success : function(data) {
        	var resultat = $.parseJSON(data);
        	var musees = resultat.musees;
        	
        },
        error : function(XHR, testStatus, errorThrown) 
		{
        	console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
    });
}

function afficheMusee(musees){
	//ajout de div dans la liste des musee
	var musee;
	for(musee in musees){
		afficheMusee(musee);
	}
}