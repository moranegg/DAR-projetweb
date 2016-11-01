$( document ).ready(function(){
	displayTime();
	$("#go").click(home.recherche);
	$("#account").click(routeur.account(id_user));
});

var home = {

		onReady: function() {
		},


		recherche: function(event){
			var elt = $("#recherche").val();
			if(elt != ""){
				alert("Je veux rechercher "+ elt);
			}else{
				alert("Pas de reherche demander");
			}
		},

		readMeteo: function(){

		},

		propositionAffluance: function(){

		},

		propositionMeteo: function(){

		}

};

var routeur = {
		index: function(){
			window.location=('index.html'); 
		},
		
		home: function(){
			window.location=('home.html?id_user'+id_user); 
		},
		
		account: function(){
			window.location=('account.html?id_user'+id_user); 
		},
		
		musee: function(id_musee){
			window.location=('musee.html?id_user'+id_user+'&'+id_musee='+id_musee); 
		},
		
		affluance: function(id_musee){
			window.location=('affluance.html?id_user'+id_user+'&'+id_musee='+id_musee); 
		}
}

function displayTime(){
	var elt = document.getElementById("day");
	var now  = new Date();
	elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();

}
