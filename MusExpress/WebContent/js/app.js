$( document ).ready(function(){
	displayTime();
	$("#go").click(home.recherche);
	$("#account").click(home.goToAccount);
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

		goToAccount: function(event){
			//ajouter id_user à l'url ou à la demande
			self.location=('templates/account.html'); 
		},

		readMeteo: function(){

		},

		propositionAffluance: function(){

		},

		propositionMeteo: function(){

		}

};



function displayTime(){
	var elt = document.getElementById("day");
	var now  = new Date();
	elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();

}
