$( document ).ready(function(){
		displayTime();
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
		type: "GET",
        url : "ConsulterUserServlet",
        dataType : 'json',
        error : function() {

            alert("problème");
        },
        success : function(data) {
        	var resultat = $.parseJSON(data);

//			var nom = resultat.nom;
//			var prenom = resultat.prenom;
//			var codep = resultat.codep;
//			var email = resultat.email;
			//var photo = ...
			document.getElementById("nom").value = resultat.nom;
			document.getElementById("prenom").value = resultat.prenom;
			document.getElementById("codep").value = resultat.codep;
			document.getElementById("email_register").value = resultat.email;
			document.getElementById("password_register").value = resultat.password;
			
        }
    });
}
function updateUser(id, nom,prenom,codep,email, password){
	$.ajax({
		type : "POST",
		url : "UpdateUserServlet",
		data : "id="+id+"&&prenom=" + prenom + "&nom=" + nom + "&codep=" + codep + "&email="
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