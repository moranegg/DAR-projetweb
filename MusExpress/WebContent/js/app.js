$( document ).ready(function(){
	displayTime();
	var id_user = GetURLParameter('id_user');
	routeur.init(id_user);

	$("#go").click(home.recherche);
	$("#account-btn").click(routeur.account);
	

	var idMusee = GetURLParameter('id_musee');
	$(".musee").click(routeur.musee);

});

var home = {

		onReady: function() {
		},


		recherche: function(event){
			console.log("home.recherche");
			var elt = $("#recherche").val();
			console.log("home.recherche de: "+elt);
			
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
