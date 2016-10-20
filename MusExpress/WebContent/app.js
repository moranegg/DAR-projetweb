 $(document).ready(function(){
       $('#login').click(function()
       {   
          var nom=$('#nom').val();
          var prenom=$('#prenom').val();
	  var codep=$('#codep').val();
          var email=$('#email').val();
	  var password=$('#password').val();
          
          $.ajax({
               type: "POST",
               url:"InscriptionServlet",
               data:{"nom":nom, "prenom": prenom, "codep":codep,"email":email,"password":password},
               success: function (data) {
                  if(data=='True'){
                    alert('success');
                  }else{
                      alert('Fail....');
                  }
               }
             });                                
           });
         });

 function displayTime(){
		var elt = document.getElementById("day");
		var now  = new Date();
		elt.innerHTML = now.getDate()+"/"+(now.getMonth()+1) + "/"+now.getFullYear();
		setTimeout(displayTime,1000);
	}	

window.onload = displayTime;

$(document).ready(function(){
    $("#go").click(function(){
    	var elt = $("#recherche").val();
    	if(elt != ""){
    		alert("Je veux rechercher "+ elt);
    	}else{
    		alert("Pas de reherche demander");
    	}
    	
        
    });
    
    //Tests du serveur avec le servlet de test
    $("#testservletget").click(function(){
    	alert("get");
        $.get("InscriptionServlet", function(data, status){
            alert("Status: " + status);
        });
    });    
    $("testservletpost").click(function(){
        $.post("demo_test_post.asp",
        {
            name: "Donald Duck",
            city: "Duckburg"
        },
        function(data, status){
            alert("Data: " + data + "\nStatus: " + status);
        });
    });
    $("#testservletget").click(function(){
    	var res;
	    $.ajax({
			url : "TestServerServlet",

			success : function(responseText) {
				
				$('#ajaxResponse').text(responseText);

			}
		});
	    
	    
    });
}); 

