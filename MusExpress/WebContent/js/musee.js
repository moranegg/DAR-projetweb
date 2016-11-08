var callbackGoogleMaps= false;
var callbackMusee =false;

$( document ).ready(function(){
	var search = $(location).attr('search'); 
	var idMusee = GetURLParameter('id_musee');
	
	var mus = musee.init(idMusee);
	var callbackGoogleMaps;

	
	musee.getAffluance();
	//var listeProx = museesAProximite(idMusee);
	//initMap(mus.nom, mus.latitude,mus.longitude,listeProx);

	$("#addComment-btn").click(musee.addComment);
	$("#add-favorits-btn").click(musee.addFavoris);
	
	$("#remove-favorits-btn").click(musee.removeFavoris);
	



});
function GoogleMaps(){
	callbackGoogleMaps = true;
}


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
			return this;
			

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
			this.showMusee();
			callbackMusee = true;
			console.log("googlemaps:"+ callbackGoogleMaps);
			if(callbackMusee == true && callbackGoogleMaps==true){
				initMap(this);
			}
			//si le musee est deja en favoris-> ne pas afficher btn-fav
			isFavoris(this.id);
			console.log(this.id);
			console.log(this.longitude);
			console.log(this.latitude);
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
		},
		addFavoris: function(){
			console.log("add favoris");
			addFavoris();
			hideDom("#add-favorits-btn");


		},
		removeFavoris: function(){
			console.log("remove favoris");
			//removeFavoris();
			//not implemented Back end
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
					hideDom("#loader-affluence");
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
	hideDom("#loader-affluence");
	var liste = eltDomList;
	$(liste).empty();
	//couleur affluence actuell
	var affActuelle = affluences[0].duree;
	if(affActuelle != undefined){
		$("#affluance_actuelle").removeClass("label-default");
		var drapeau = "danger";
		if(affActuelle.startsWith("10min")){
			drapeau = "success";
		}else if(affActuelle.startsWith("10-30")){
			drapeau = "primary";
		}else if(affActuelle.startsWith("30-60")){
			drapeau = "warning";
		}
		$("#affluance_actuelle").addClass("label-"+drapeau);
	}
	
	for(i=0; i<affluences.length && i<10; i++)
	{
		var duree= affluences[i].duree;
		var drapeau = "danger";
		if(duree.startsWith("10min")){
			drapeau = "success";
		}else if(duree.startsWith("10-30")){
			drapeau = "primary";
		}else if(duree.startsWith("30-60")){
			drapeau = "warning";
		}
		$(liste).append('<li class="list-group-item"><span class="label label-'+drapeau+' "><span class="glyphicon glyphicon-flag"></span></span> <span class="commentaire">'+affluences[i].text+'</span> <span	class="text-info ext">'+affluences[i].emplacement+'</span> <span class="badge temps">'+affluences[i].date+'</span></li></li>');
		console.log(affluences[i].id);

	}

}
/**************************Favoris*************************************/
function addFavoris()
{
	 console.log("before server");
	$.ajax
	({
		type: "GET",
		url : "AjoutMuseeFavServlet",
		data : {"iduser" : GetURLParameter("id_user"),
			    "idmusee" : GetURLParameter("id_musee"),  
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
function isFavoris(idMusee){
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
				var musees = data.musee;
				var isFavoris = false;
				for(i =0; i<musees.length;i++ ){
					if(musees[i].id == idMusee){
						isfavoris = true;
						return true;
					}
				}
				if(isFavoris==false){
					showDom("#add-favorits-btn");
				};	
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}
/***************************************************************************************/

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


/**************************GOOGLE MAP****************************************************/
/**
 * Envoyer à la servlet
 */
function museesAProximite(idMusee)
{
	 console.log("before server");
	$.ajax
	({
		type: "GET",
		url : "AfficherMuseesProximiteServlet",
		data : {
			    "idmusee" : idMusee,  
			    },
		dataType : 'JSON',
		success : function(data) 
		{
			if (data.message==1)
			{
				return data.musees;
                console.log("success");                
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}
/**
 * Affichage de google map
 */
function initMap(mus) {
	console.log(mus);
	var museeActuel = {lat: mus.latitude, lng: mus.longitude};
	console.log("map");
	var map = new google.maps.Map(document.getElementById('map'), {
		center: museeActuel,
		zoom: 14,
		panControl: false,
		scrollwheel: false,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});

	var marker = new google.maps.Marker({
		position: museeActuel,
		map: map,
		title: mus.nom
	});

//	var contentString = '<div class="info-window">' +
//	'<h3>Info Window Content</h3>' +
//	'<div class="info-content">' +
//	'<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>' +
//	'</div>' +
//	'</div>';

//	var infowindow = new google.maps.InfoWindow({
//		content: contentString,
//		maxWidth: 400
//	});


//	marker.addListener('click', function () {
//		infowindow.open(map, marker);
//	});

	var styles = [{"featureType": "landscape", "stylers": [{"saturation": -100}, {"lightness": 65}, {"visibility": "on"}]}, {"featureType": "poi", "stylers": [{"saturation": -100}, {"lightness": 51}, {"visibility": "simplified"}]}, {"featureType": "road.highway", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "road.arterial", "stylers": [{"saturation": -100}, {"lightness": 30}, {"visibility": "on"}]}, {"featureType": "road.local", "stylers": [{"saturation": -100}, {"lightness": 40}, {"visibility": "on"}]}, {"featureType": "transit", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "administrative.province", "stylers": [{"visibility": "off"}]}, {"featureType": "water", "elementType": "labels", "stylers": [{"visibility": "on"}, {"lightness": -25}, {"saturation": -100}]}, {"featureType": "water", "elementType": "geometry", "stylers": [{"hue": "#ffff00"}, {"lightness": -25}, {"saturation": -97}]}];

	map.set('styles', styles);


	google.maps.event.addDomListener(window, 'load', initMap);
	var aProximite =  museesAProximite(mus.id);
	if(aProximite != undefined){
		console.log(aProximite);
		for(i=0; i<aProximite.length; i++)
		{
			new google.maps.Marker({
				position: aProximite[i].localisation,
				map: map,
				title: aProximite[i].nomMusee,
				icon: //'http://maps.google.com/mapfiles/ms/icons/blue-dot.png'
					'images/museum-icon-32.png'
			});
		}
	}

}
