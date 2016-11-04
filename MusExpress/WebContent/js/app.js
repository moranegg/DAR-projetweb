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


