var callbackGoogleMapsHome= false;
var callbackPropAff =false;
var callbackPropMeteo =false;

$( document ).ready(function(){
	//function shows time in navbar
	displayTime();

	//show tooltip data on btn (star-favoris)
	$("[data-toggle='tooltip']").tooltip();

	var path = window.location.pathname;
	if(path != "/MusExpress/" || path != "/MusExpress/index.html"){
		var id_user = GetURLParameter('id_user');
		routeur.init(id_user);
		if(path == "/MusExpress/home.html"){
			home.propositionAffluance();
			getPropMeteo();
			home.readMeteo();
		}
	}


	$("#recherche-btn").click(home.recherche);
	$("#account-btn").click(routeur.account);


	var idMusee = GetURLParameter('id_musee');


	$(".navbar-brand").click(function(event) {
		var idUser = GetURLParameter('id_user');
		if(idUser != undefined){
			routeur.home(idUser);
		}else{
			routeur.index;
		}
	});

	$(".musee").click(function(event) {
		console.log("clickmusee");
		$(".musee").click(routeur.musee(event.target.id));
	});


});

/**
 * Object home
 */
var home = {
		museesPropAff: null,
		museesPropMeteo: null,

		onReady: function() {
		},

		//
		recherche: function(event)
		{
			var liste = "#liste_recherche";
			$(liste).empty();
			//console.log("home.recherche");
			var textRecherche = $("#recherche-input").val();
			//console.log("home.recherche de: "+textRecherche);
			if(textRecherche == undefined || textRecherche == ''){

				$(liste).append('<li class="list-group-item ">Le champ recherche est vide</li>');
			} else {
				var musees = sendRecherche(textRecherche);
			}


		},

		readMeteo: function(){

			var div_meteo = $("#meteo");
			//var meteo = sendMeteo(meteo_json);
			sendMeteo();



		},

		propositionAffluance: function(){
			getAffluances();

		},

		propositionMeteo: function(){
			getPropMeteo();
		}

};
/**
 * Router object: validates navigation
 */
var routeur = {
		idUser: "",

		index: function(){
			window.location=('index.html');
		},

		init: function(){
			this.idUser = GetURLParameter('id_user');
		},

		home: function(id_user){
			this.idUser = id_user;
			if(this.idUser=="" || this.idUser==undefined){
				this.index();
			}else{
				window.location=('home.html?id_user='+this.idUser);
			}
		},

		account: function(){
			window.location=('account.html?id_user='+GetURLParameter('id_user')); 

		},

		musee: function(idMusee){
			window.location=('musee.html?id_user='+this.idUser+'&id_musee='+idMusee);

		},
}
/**
 * Sends request to GetWeatherServlet for Meteo of the day
 */
function sendMeteo(){
	$.ajax({
		type: "GET",
		date:{},
		url : "GetWeatherServlet",
		dataType : 'json',

		success : function(data) {
			var div_meteo = $("#meteo");
			if(data.message="1")
			{
				var temp = data.temp;
				var temp_min = data.temp_min;
				var temp_max = data.temp_max;
				var humidity = data.humidity;
				var sunrise = data.sunrise;
				//var sunset = data.sunset;
				var icon = data.weather[0].icon;

				$("#icon").append('<img src ="'+icon+'" width="70" height = "70"></img>');
				$("#temp").append(temp+"° C");
				$("#temp_min").append(temp_min+"° C");
				$("#temp_max").append(temp_max+"° C");
				$("#humidity").append(humidity + " %");
				//$("#sunrise").append(new Date(parseInt(sunrise)));


			}
		},
		error : function(XHR, testStatus, errorThrown)
		{
			//console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}
/**
 * Displays today date and time in dom elemnt "day"
 */
function displayTime(){
	var elt = "#day";
	var now  = new Date();
	$(elt).append(now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear()+"  "+(now.getHours())+":"+(now.getMinutes()+1)+":"+(now.getSeconds()+1));

}
/**
 * Get Parameter in actuel Url
 * @param sParam
 * @returns
 */
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
/**
 * prints a message inside dom elemnt
 * @param dom
 * @param msg
 */
function printhtml(dom,msg)
{
	$(dom).html(msg);
	$(dom).removeClass('hide');
}

/***hide dom elemnt**/
function hideDom(dom)
{
	$(dom).addClass('hide');
}
/*** shows dom element**/
function showDom(dom)
{
	$(dom).removeClass('hide');
}

/**
 * checks if text was entered in form
 * @param text
 * @returns {Boolean}
 */
function checkIsText(text){
	if(text.length==0)
	{
		return false;
	}else{
		return true;
	}
}
/**
 * regex checks email is correct
 * @param email
 * @returns
 */
function isEmail(email){

	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);

}
/**
 * hides loader from view and shows form again
 * @param loader
 * @param btn
 */
function resetForm(loader, btn){
	hideDom(loader);
	showDom(btn);
}


/*******************************       Rechercher un musée        *************************/
/**
 *
 * Message sent to server with text in search => textRecherche
 */
function sendRecherche(textRecherche){
	//console.log("send to RechercherMuseeServlet");
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
				var musees = resultat.musees;
				if (musees.length!=0)
				{

					//affichage de la modal avec les résultat
					var eltDomList = "#liste_recherche";
					//vider la liste avant recherche
					$(eltDomList).empty();
					afficheMuseeRecherche(musees, eltDomList);
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

/**
 *
 * @returns liste of museums to test display methods
 */
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
function afficheMuseeRecherche(musees, eltDomList){
	console.log("afficheMusee" + eltDomList);

	var liste = eltDomList;
	$(liste).empty();
	for(i=0; i<musees.length; i++)
	{
		$(liste).append('<li class="list-group-item musee btn " id="'+musees[i].id+'">'+musees[i].nom+'</li>');

	}

	$(".musee").click(function(event) {

		$(".musee").click(routeur.musee(event.target.id));
	});
}

/**
 *
 * @param musees
 * @param eltDomList
 */
function afficheMusee(musees, eltDomList){
	console.log("afficheMusee");

	var liste = eltDomList;
	$(liste).empty();
	for(i=0; i<musees.length; i++)
	{

		$(liste).append('<li class="list-group-item musee btn " id="'+musees[i].id+'">'+musees[i].nom+'</li>');

		//console.log(musees[i].id);

	}
}


/*************************** Récupérer les propositions de musées par affluance ********************************/


function getAffluances(){
	//favoris par FavorisSerrvlet
	console.log("getAffluances");
	$.ajax({
		type: "GET",
		data:{},
		url : "AfficherPropAffServlet",
		dataType : 'json',

		success : function(data) {
			//var resultat = $.parseJSON(data);
			var resultat = data;
			if (resultat.message==1)
			{
				//To do change to musees
				var musees = resultat.musees;
				var eltDomList = "#list-affluance";
				if(musees.length == 0)
				{
					$("#list-affluance").append('<li class="list-group-item" >Aucune information pour le moment</li>');
				}
				else
				{
					var affluances = [];
					affluances.push(musees[0]);
					//alert(musees[0]);
					//effacer les doublons
					for(var i = 1; i< musees.length;i++){
						var exists = false;
						for(var j = 0; j< affluances.length;j++){
							if(musees[i].id==affluances[j].id){
								exists = true;
								break;
							}
						}
						if(exists== false){
							affluances.push(musees[i]);
						}

					}
					afficheMuseeRecherche(affluances, eltDomList);
					home.museesPropAff =affluances;
					callbackPropAff = true;
					console.log("googlemapshome:"+ callbackGoogleMapsHome);
					if(callbackPropMeteo == true && callbackGoogleMapsHome==true){
						initMap();
					}
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



function affichePropMusee(affluences, eltDomList)
{

	console.log("affichePropAffluence");

	var liste = eltDomList;
	$(liste).empty();
	for(i=0; i<affluences.length && i<10; i++)
	{
		$(liste).append('<li class="list-group-item">'+affluences[i].musee+'</li>');
		//console.log(affluences[i].id);

	}

}

/************************* Propositions selon la Météo**************************************/
function getPropMeteo(){
	//favoris par FavorisSerrvlet
	console.log("getPropMeteo");
	$.ajax({
		type: "GET",
		date:{},
		url : "AfficherPropMeteoServlet",
		dataType : 'json',

		success : function(data) {

			if (data.message==1)
			{
				var musees = data.propositions;//propositions sont des musées !
				var eltDomList = "#list-meteo";
				hideDom("#loader-propMeteo");
				if(musees.length == 0)
				{
					$("#list-meteo").append('<li class="list-group-item" >Aucune information pour le moment</li>');
				}
				else
				{
					//affichePropMeteo(musees, eltDomList);
					afficheMuseeRecherche(musees,eltDomList);
					home.museesPropMeteo =musees;

				}
			}
		},
		error : function(XHR, testStatus, errorThrown)
		{
			hideDom("#loader-propMeteo");
			$("#list-meteo").append('<li class="list-group-item" >Aucune information pour le moment</li>');
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		},
		complete: function(){
			callbackPropMeteo = true;
			console.log("googlemapshome:"+ callbackGoogleMapsHome);
			if(callbackPropAff == true && callbackGoogleMapsHome==true){
				initMap();
			}
		}
	});
}
function affichePropMeteo(propositions, eltDomList)
{

	var liste = eltDomList;
	$(liste).empty();
	for(i=0; i<propositions.length && i<5; i++)
	{
		$(liste).append('<li class="list-group-item">'+propositions[i].musee+'</li>');

	}

}
/**************GoogleMaps functions ************************************/
function GoogleMapsHome(){
	callbackGoogleMapsHome = true;
}

function initMap(){
	console.log("init map");
	//console.log(home.museesPropAff);
	//console.log(home.museesPropMeteo);


	var m = home.museesPropAff[0].localisation;

	console.log("map");
	var map = new google.maps.Map(document.getElementById('map'), {
		center: m,
		zoom: 9,
		panControl: false,
		scrollwheel: false,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});

	var styles = [{"featureType": "landscape", "stylers": [{"saturation": -100}, {"lightness": 65}, {"visibility": "on"}]}, {"featureType": "poi", "stylers": [{"saturation": -100}, {"lightness": 51}, {"visibility": "simplified"}]}, {"featureType": "road.highway", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "road.arterial", "stylers": [{"saturation": -100}, {"lightness": 30}, {"visibility": "on"}]}, {"featureType": "road.local", "stylers": [{"saturation": -100}, {"lightness": 40}, {"visibility": "on"}]}, {"featureType": "transit", "stylers": [{"saturation": -100}, {"visibility": "simplified"}]}, {"featureType": "administrative.province", "stylers": [{"visibility": "off"}]}, {"featureType": "water", "elementType": "labels", "stylers": [{"visibility": "on"}, {"lightness": -25}, {"saturation": -100}]}, {"featureType": "water", "elementType": "geometry", "stylers": [{"hue": "#ffff00"}, {"lightness": -25}, {"saturation": -97}]}];

	map.set('styles', styles);


	google.maps.event.addDomListener(window, 'load', initMap);
	//console.log(home.museesPropAff);
	//console.log(home.museesPropMeteo);
	if(home.museesPropAff != null){

		for(i=0; i<home.museesPropAff.length; i++)
		{
			var prox = new google.maps.Marker({
				position: home.museesPropAff[i].localisation,
				map: map,
				title: home.museesPropAff[i].nom,
				icon:'images/red-icon.png',

			});
		}
	}
	if(home.museesPropMeteo != null){

		for(i=0; i<home.museesPropMeteo.length; i++)
		{
			var prox = new google.maps.Marker({
				position: home.museesPropMeteo[i].localisation,
				map: map,
				title: home.museesPropMeteo[i].nom,
				icon: 'images/blue-icon.png',

			});
		}
	}

}
