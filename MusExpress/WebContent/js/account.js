$( document ).ready(function(){
		displayTime();
		$("#update-btn").click(account.update);
		
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
		type: "GET",
        url : "NameServlet",
        dataType : 'json',
        error : function() {

            alert("problème");
        },
        success : function(data) {
        	var resultat = $.parseJSON(data);

			var nom = resultat.nom;
			var prenom = resultat.prenom;
			var codep = resultat.codep;
			var email = resultat.email;
			//var photo = ...
			
        }
    });
}
function updateUser(nom,prenom,codep,email, password){
	$.ajax({
		type : "POST",
		url : "updateUserServlet",
		data : "prenom=" + prenom + "&nom=" + nom + "&codep=" + codep + "&email="
				+ email+ "&password=" + password,
		dataType : "json",
		success : function(){
			alert("updated!");
			
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			alert(XHR + "" + testStatus + "" + errorThrown);
		}
	});
}
function readFavoris(){
	//favoris par FavorisSerrvlet
	$.ajax({
		type: "POST",
        url : "NameServlet",
        data : userId,
        dataType : 'json',
        error : function() {

            alert("problème");
        },
        success : function(data) {
        	var resultat = $.parseJSON(data);
        	
        	var musees = resultat.musees;
        	var musee;
        	for(musee in musees){
        		afficheMusee(musee);
        	}
        }
    });
}

function afficheMusee(musee){
	//ajout de div dans la liste des musee
}