var callbackGoogleMaps= false;
var callbackMusee =false;
var callbackProx = false;

function myTimer() {
    console.log(' each 3 minute...');
    getAffluences();
}

var myVar = setInterval(function(){ myTimer() }, 30000);

$( document ).ready(function(){
	var search = $(location).attr('search'); 
	var idMusee = GetURLParameter('id_musee');
	var idU = GetURLParameter('id_user');

	if(idMusee== undefined){
		if(idU== undefined){
			routeur.index();
		}
		routeur.home(idU);
	}

	var mus = musee.init(idMusee);


	museesAProximite(idMusee);
	musee.getAffluance();

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
		approx: null,
		isFavoris: null,


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
			//console.log("setMusee.googlemaps:"+ callbackGoogleMaps);
			//console.log("setMusee.prox:"+ callbackProx);
			if(callbackProx == true && callbackGoogleMaps==true){
				initMap(this);
			}
			//si le musee est deja en favoris-> ne pas afficher btn-fav
			if(this.isfavoris == null){
				this.isfavoris = isFavoris(this.id);
				console.log("this.isfavoris: "+ this.isfavoris);
			}
			

		},

		showMusee: function(){
			$("#id_musee").append(this.id);
			$("#nom_musee").append(this.nom);
			$("#adresse_musee").append(this.adresse);
			$("#ville_musee").append(this.ville);
			$("#departement_musee").append(this.departement);
			$("#codep_musee").append(this.codep);

			$("#ferme_musee").append(this.ferme);
			$("#siteweb_musee").append("<a href=\"http://"+this.siteweb+"\">"+this.siteweb+"<\a>");
			$("#periode_ouvertue_musee").append(this.periode_ouvertue);
			$("#fermeture_annuelle_musee").append(this.fermeture_annuelle);
			$("#latitude_musee").append(this.latitude);
			$("#longitude_musee").append(this.longitude);
		},


		getAffluance: function(){
			console.log("musee.getAffluance");
			getAffluences();


		},
		setAprox: function(aProximite){
			console.log("setAprox.googlemaps:"+ callbackGoogleMaps);
			console.log("setAprox.prox:"+ callbackProx);
			console.log("setAprox.musee:"+ callbackMusee);
			this.approx = aProximite;
			callbackProx =true;
			console.log("googlemaps:"+ callbackGoogleMaps);
			if(callbackMusee == true && callbackGoogleMaps==true){
				initMap(this);
			}
		},
		addComment: function(){
			console.log("add comment");
			$("#affluance-notifier").addClass('hide');
			var im =this.id;
			var iu =GetURLParameter("id_user");			
			var emplacement= $('input[name=emplacement]:checked', '#form_add_affluence').val();
			var text= $("#commentaire-text").val();
			var duree= $('input[name=duree]:checked', '#form_add_affluence').val();
			if(im != undefined && iu != undefined &&emplacement!=undefined &&text!=undefined 
					&& duree!=undefined){
				addAffluence();
				$("#affluanceModal").modal('hide');
				hideDom("affluance-notifier");
			}else{
				$("#affluance-notifier").removeClass('hide');
			}
			
			
		},
		addFavoris: function(idMusee,idU){
			console.log("add favoris");
			addFavoris();
			


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

			var museeFromDB = data.musee;
			if (data.message==1)
			{
				musee.setmusee(museeFromDB);

			}	

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
			routeur.home(routeur.idUser);
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
			if (data.message==1)
			{
				console.log("success");
				showDom("#loader-affluence");
				getAffluences();

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
					$("#liste_aff").empty();
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

	for(i=0; i<affluences.length && i<7; i++)
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
	var idMusee = GetURLParameter('id_musee');
	var idU = GetURLParameter('id_user');
	hideDom("#add-favorits-btn");
	
	//console.log("add favoris ajax"+ idU+" "+idMusee);
	$.ajax
	({
		type: "GET",
		url : "AjoutMuseeFavServlet",
		data : {"iduser" : idU,
			"idmusee" :idMusee,  
		},
		dataType : 'JSON',
		success : function(data) 
		{
			console.log("add favoris success");
			var resultat = data;         
			hideDom("#add-favorits-btn");
			hideDom("#add-favorits-btn");
			if (resultat.message==1)
			{
				//console.log("add favoris success");
				
			}

		},
		error : function(XHR, testStatus, errorThrown) 
		{
			//console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
			showDom("#add-favorits-btn");
		}
	});
}
/**
 * Checks if musee is in favoris
 * @param idMusee
 */
function isFavoris(idMusee){
	var isFavoris = false;
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
				for(i =0; i<musees.length;i++ ){
					if(musees[i].id == idMusee){
						isfavoris = true;
						hideDom("#add-favorits-btn");
						return true;
					}
				}
				
			}
			return isFavoris;
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
			return isFavoris;
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



/**************************GOOGLE MAP****************************************************/
/**
 * sends ajax to AfficherMuseesProximiteServlet
 */
function museesAProximite(idMusee)
{
	console.log("before server");
	$.ajax
	({
		type: "GET",
		url : "AfficherMuseesProximiteServlet",
		data : {
			"id_musee" : idMusee,  
		},
		dataType : 'JSON',
		success : function(data) 
		{
			if (data.message==1)
			{
				musee.setAprox(data.musees);
				console.log("success");                
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			var test =[
			{
				nomMusee: 'Galerie d’entomologie (Muséum national d\'histoire naturelle)',
				id: 4,
				localisation : 
				{
					lat: 48.8443464,
					lng: 2.3562118
				},

			},
			{
				nomMusee: 'Musée Hébert',
				id: 5,
				localisation : 

				{
					lat: 48.8474495,
					lng: 2.3227049
				},

			},
			{
				nomMusee: 'Musée Zadkine',

				id: 6,

				localisation : 
				{
					lat: 48.8443793,
					lng: 2.3328737
				},
			},
			{

				nomMusee: 'Musée National Auguste Rodin',
				id: 8,
				localisation : 
				{
					lat: 48.8513447,
					lng: 2.3272485
				},
			},
			{
				nomMusee: 'Musée National de la Légion d\'Honneur et des Ordres de Chevalerie',
				id: 9,
				localisation : 
				{
					lat:  48.860275,
					lng: 2.3247399
				},
			},
			{
				nomMusee: 'Musée Lénine',
				id: 10,
				localisation : 
				{
					lat:  48.8263909,
					lng: 2.3306427
				},
			},
			];
			musee.setAprox(test);
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}
/**
 * Affichage de google map
 */
function initMap(mus) {
	console.log(mus);
	var museeActuel = {lat: parseFloat(mus.latitude), lng: parseFloat(mus.longitude)};
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
		title: mus.nom,
		icon: 'images/red-icon.png',
	});	

	var styles = [{"featureType": "landscape", "stylers": [{"saturation": -100}, {"lightness": 65}, {"visibility": "on"}]}, {"featureType": "poi", "stylers": [{"saturation": -100}, {"lightness": 51}, {"visibility": "simplified"}]}, {"featureType": "road.highway", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "road.arterial", "stylers": [{"saturation": -100}, {"lightness": 30}, {"visibility": "on"}]}, {"featureType": "road.local", "stylers": [{"saturation": -100}, {"lightness": 40}, {"visibility": "on"}]}, {"featureType": "transit", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "administrative.province", "stylers": [{"visibility": "off"}]}, {"featureType": "water", "elementType": "labels", "stylers": [{"visibility": "on"}, {"lightness": -25}, {"saturation": -100}]}, {"featureType": "water", "elementType": "geometry", "stylers": [{"hue": "#ffff00"}, {"lightness": -25}, {"saturation": -97}]}];

	map.set('styles', styles);

	google.maps.event.addDomListener(window, 'load', initMap);
	var aProximite =  mus.approx;
	//var aProximite = testProximite;
	if(aProximite != undefined){
		console.log(aProximite);
		for(i=0; i<aProximite.length; i++)
		{
			var prox = new google.maps.Marker({
				position: aProximite[i].localisation,
				map: map,
				title: aProximite[i].nomMusee,
				icon: 'images/blue-icon.png',

			});

//			var contentString = '<div class="info-window">' +
//			'<h4>'+aProximite[i].nomMusee+'</h4>' +
//			'<div class="info-content">' +
//			'<div class="btn btn-primary musee" id="'+aProximite[i].id+'">Voir musée</div>'+
//			'</div>' +
//			'</div>';

//			var infowindow = new google.maps.InfoWindow({
//			content: contentString,
//			maxWidth: 400
//			});


//			prox.addListener('click', function () {
//			infowindow.open(map, prox);
//			});			
		}


	}



}
