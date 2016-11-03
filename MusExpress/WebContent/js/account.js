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
		type: "GET",
        url : "ConsulterUserServlet",
        dataType : 'json',
        data : {
        	id_user : GetURLParameter('id_user')
        },
        success : function(data) {
        	
        	//var resultat = $.parseJSON(data);
        	var resultat = data;
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
        	 console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
    });
}
function updateUser(id, nom,prenom,codep,email, password){
	$.ajax({
		type : "GET",
		url : "UpdateUserServlet",
		data : {
			"id": GetURLParameter('id_user'),
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