$( document ).ready(function(){
	displayTime();
	var id_user = GetURLParameter('id_user');
	routeur.init(id_user);

	$("#recherche-btn").click(home.recherche);
	$("#account-btn").click(routeur.account);


	var idMusee = GetURLParameter('id_musee');
	$(".navbar-brand").click(routeur.index);
	
	
});

var home = {

		onReady: function() {
		},
		recherche: function(event){
			console.log("home.recherche");
			var textRecherche = $("#recherche-input").val();
			console.log("home.recherche de: "+textRecherche);
			//var musees = sendRecherche(textRecherche);
			
			var musees = testRechercheMusee().musees;
			var eltDomList = "#liste_recherche";
			//vider la liste avant recherche
			$(eltDomList).empty();
			afficheMusee(musees, eltDomList)

		},

		readMeteo: function(){

		},

		propositionAffluance: function(){

		},

		propositionMeteo: function(){

		}

};

var routeur = {
		idUser: "",

		index: function(){
			console.log("routeur.index");
			window.location=('index.html'); 
		},

		init: function(){
			this.idUser = GetURLParameter('id_user');
		},

		home: function(id_user){
			console.log("routeur.home");
			this.idUser = id_user;
			window.location=('home.html?id_user'+this.idUser);


		},

		account: function(){
			console.log("routeur.account");
			window.location=('account.html?id_user'+this.idUser); 

		},

		musee: function(idMusee){
			console.log("routeur.musee");
			window.location=('musee.html?id_user'+this.idUser+'&id_musee='+idMusee); 

		},
}

function sendRecherche(textRecherche){
	console.log("send to RechercherMuseeServlet");
	$.ajax({
		type : "GET",
		url : "RechercherMuseeServlet",
		data :{
			"nom_musee":textRecherche,
		},

		dataType : "json",
		success : function(data) { 
			console.log("success from RechercherMuseeServlet");
		//var resultat = $.parseJSON(data);
		//var resultat = JSON.parse(JSON.stringify(data));
		var resultat=data;


		console.log("resultat.message: "+resultat.message);
		if (resultat.message=="1") 		
			{
				console.log("resultat.musees: "+resultat.musees);
				//affichage de la modal avec les résultat
				return result;
			} 
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);

		}
	});
}

function displayTime(){
	var elt = document.getElementById("day");
	var now  = new Date();
	elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();

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

function printhtml(dom,msg)
{
	$(dom).html(msg);
	$(dom).removeClass('hide');
}


function hideDom(dom)
{
	$(dom).addClass('hide');
}

function showDom(dom)
{
	$(dom).removeClass('hide');
}


function checkIsText(text){
	if(text.length==0)
	{
		return false;
	}else{
		return true;
	}
}
function isEmail(email){

	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);

}
function resetForm(loader, btn){
	hideDom(loader);
	showDom(btn);
}

function testRechercheMusee(){
	var messageSserveur = {"message":"1",
			"musees":[
			         {"id":4,
			        	 "nom":"Galerie d\u2019entomologie (Muséum national d'histoire naturelle)"
			         },
			         {"id":150,
			        	 "nom":"Musée des traditions, ParcGâtinais français"
			        }]}
	return messageSserveur;
}
/**
 * 
 * @param musees
 * @param eltDomList
 */
function afficheMusee(musees, eltDomList){
	console.log("afficheMusee");
	var liste = eltDomList;
	for(i=0; i<musees.length; i++)
	{
		$(liste).append('<li class="list-group-item musee btn " id="'+musees[i].id+'">'+musees[i].nom+'</li>');
		console.log(musees[i].id);

	}
	
	$(".musee").click(function(event) {
		
        $(".musee").click(routeur.musee(event.target.id));
	   });
}
/**
 * Affichage de google map
 */
function initMap() {
	  var museeActuel = {lat: 48.8596, lng: 2.3369};
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
		    title: 'Le Louvre'
			  });

	var contentString = '<div class="info-window">' +
	'<h3>Info Window Content</h3>' +
	'<div class="info-content">' +
	'<p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>' +
	'</div>' +
	'</div>';

	var infowindow = new google.maps.InfoWindow({
		content: contentString,
		maxWidth: 400
	});

	marker.addListener('click', function () {
		infowindow.open(map, marker);
	});

	var styles = [{"featureType": "landscape", "stylers": [{"saturation": -100}, {"lightness": 65}, {"visibility": "on"}]}, {"featureType": "poi", "stylers": [{"saturation": -100}, {"lightness": 51}, {"visibility": "simplified"}]}, {"featureType": "road.highway", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "road.arterial", "stylers": [{"saturation": -100}, {"lightness": 30}, {"visibility": "on"}]}, {"featureType": "road.local", "stylers": [{"saturation": -100}, {"lightness": 40}, {"visibility": "on"}]}, {"featureType": "transit", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "administrative.province", "stylers": [{"visibility": "off"}]}, {"featureType": "water", "elementType": "labels", "stylers": [{"visibility": "on"}, {"lightness": -25}, {"saturation": -100}]}, {"featureType": "water", "elementType": "geometry", "stylers": [{"hue": "#ffff00"}, {"lightness": -25}, {"saturation": -97}]}];

	map.set('styles', styles);


	google.maps.event.addDomListener(window, 'load', initMap);
	var aProximite = [{
		nomMusee: 'test1',
		localisation : {
			lat: 48.8592, 
			lng: 2.3379
		},
	},{
		nomMusee: 'test2',
		localisation : {
			lat: 48.8567, 
			lng: 2.3359
		}
	},{
		nomMusee: 'test3',
		localisation : {
			lat: 48.8567, 
			lng: 2.3349
		}
	}];

	for(i=0; i<aProximite.length; i++)
	{
		new google.maps.Marker({
			    position: aProximite[i].localisation,
			    map: map,
			    title: aProximite[i].nomMusee,
			icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png'
				  });
	}



}

