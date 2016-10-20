var home = {
 
    onReady: function() {
    },

    displayTime: function(){
    	alert("coucou");
    		var elt = document.getElementById("day");
    		var now  = new Date();
    		elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();
    },	
    	
    recherche: function(event){
    	var elt = $("#recherche").val();
    	if(elt != ""){
    		alert("Je veux rechercher "+ elt);
    	}else{
    		alert("Pas de reherche demander");
    	}
    },
    
    account: function(event){
    	alert("account");
    }
 
};
 
$( document ).ready(function(){
		displayTime();
		$("#go").click(home.recherche);
		$("#account").click(home.account);
	});

function displayTime(){
		var elt = document.getElementById("day");
		var now  = new Date();
		elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();
		
}