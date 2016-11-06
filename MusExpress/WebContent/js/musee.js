

var musee = {
		id : "",
		nom: "",
		adresse: "",
		ville: "",
		departement: "",
		codep: "",
		ferme: "",
		siteweb: "",
		periode_ouvertue: "",
		fermeture_annuelle: "",
		latitude: "", 
		longitude: "",


		init: function(idMusee)
		{
			this.id = idMusee;
			//appel à la BDD
			var museeFromDB = readMusee(idMusee);
			

		},

		setmusee: function(museeFromDB)
		{				
			this.nom = museeFromDB.nom;
			this.adresse = museeFromDB.adresse;
			this.ville = museeFromDB.ville;
			this.departement =museeFromDB.departement;
			this.codep = museeFromDB.codep;
			this.ferme = museeFromDB.ferme;
			this.siteweb = museeFromDB.siteweb;
			this.periode_ouvertue =museeFromDB.periode_ouvertue;
			this.fermeture_annuelle = museeFromDB.fermeture_annuelle;
			this.latitude =museeFromDB.latitude;
			this.longitude =museeFromDB.longitude;
			//console.log(museeFromDB.periode_ouvertue);			
			//console.log("musee.init.après :"+this);
			this.showMusee()
		},

		showMusee: function(){
			$("#id_musee").append(this.id);
			$("#nom_musee").append(this.nom);
			$("#adresse_musee").append(this.adresse);
			$("#ville_musee").append(this.ville);
			$("#departement_musee").append(this.departement);
			$("#codep_musee").append(this.codep);

			$("#ferme_musee").append(this.ferme);
			$("#siteweb_musee").append("<href>"+this.siteweb +"<\href>");
			$("#periode_ouvertue_musee").append(this.periode_ouvertue);
			$("#fermeture_annuelle_musee").append(this.fermeture_annuelle);
			$("#latitude_musee").append(this.latitude);
			$("#longitude_musee").append(this.longitude);
		},

		addToFavorits: function(){

		},
		getAffluance: function(){
			console.log("musee.getAffluance");
			getAffluences();


		},
		getLocalisation: function(){

		},
		addComment: function(){
			console.log("add comment");
			this.id;
			addAffluence();
			$("#affluanceModal").modal('hide');
		}
}





/************************************Afficher les informations du musée *************************/
function readMusee(idMusee)
{
	$.ajax
	({
		type: "GET",
		url : "ConsulterMuseeServlet",
		data : {id : idMusee},
		dataType : 'JSON',
		success : function(data) 
		{

			var resultat = data;



			var museeFromDB = resultat.musee;
			//alert (museeFromDB.nom);
			if (resultat.message==1)
			{
				musee.setmusee(museeFromDB);

			}
			//return museeFromDB;	

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
			resetForm('#loader-login','#login-btn');
		}
	});
}


/************************************    Ajout d'un commentaire *************************/


function addAffluence()
{

	$.ajax
	({
		type: "GET",
		url : "AjoutAffluenceServlet",
		data : {"id_user" : GetURLParameter("id_user"),
			    "id_musee" : GetURLParameter("id_musee"),
			    "emplacement": $('input[name=emplacement]:checked', '#form_add_affluence').val(),
			    "text" : $("#commentaire-text").val(), 
			    "duree" : $('input[name=duree]:checked', '#form_add_affluence').val()
			    },
		dataType : 'JSON',
		success : function(data) 
		{

			var resultat = data;           


			if (resultat.message==1)
			{
                 console.log("success");
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}


/********************************** Afficher les derniers commentaires du musée *************************/


function getAffluences(){
	$.ajax({
		type: "GET",
		url : "AfficherAffluenceMuseeServlet",
		data : {
			id_musee:GetURLParameter('id_musee'), 
		},
		dataType : 'json',

		success : function(data) {
			var resultat = data;
			if (resultat.message==1)
			{
				var affluences = resultat.affluence;
				var eltDomList = "#liste_aff";
				if(affluences.length == 0)
				{
					$("#liste_aff").append('<li class="list-group-item info" >Aucune information pour le moment</li>');
				} 
				else 
				{
					afficheAffluence(affluences, eltDomList);
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

function afficheAffluence(affluences, eltDomList)
{

	console.log("afficheAffluence");

	var liste = eltDomList;
	$(liste).empty();
	for(i=0; i<affluences.length && i<10; i++)
	{
		$(liste).append('<li class="list-group-item"><span class="label label-success "><span class="glyphicon glyphicon-flag"></span></span> <span class="commentaire">'+affluences[i].text+'</span> <span	class="text-info ext">'+affluences[i].emplacement+'</span> <span class="badge temps">'+affluences[i].date+'</span></li></li>');
		console.log(affluences[i].id);

	}

}


function testMusee(idMusee){
	var museeExample = {
			id : idMusee,
			nom: "test_nom",
			adresse: "test_adresse",
			ville: "test_ville",
			departement: "test_dep",
			codep: "test_codep",
			ferme: "test_ferme",
			siteweb: "http://test.siteweb.com",
			periode_ouvertue: "test_periode_ouverture",
			fermeture_annuelle: "test_fermeture_a",
			latitude: "test_latitude", 
			longitude: "test_longitude",
	}
	console.log("testMusee :"+museeExample);
	return museeExample;

}

function GetURLParameter(sParam)
{
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for (var i = 0; i < sURLVariables.length; i++) 
	{
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam) 
		{
			return sParameterName[1];
		}
	}
}

$( document ).ready(function(){
	var search = $(location).attr('search'); 
	var idMusee = GetURLParameter('id_musee');
	
	var mus = musee.init(idMusee);
	musee.getAffluance();

	$("#addComment-btn").click(musee.addComment);




});
