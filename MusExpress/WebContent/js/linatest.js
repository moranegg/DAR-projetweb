function enregistre(formulaire) 
{
	var idmusee = formulaire.idmusee.value;
	var iduser = formulaire.iduser.value;

	//var nom = formulaire.iduser.value;
	
	//alert (idmusee);
	//alert (iduser);

	
	$.ajax({
		type : "POST",
		//url : "RechercherMuseeServlet",
		url : "AjoutMuseeFavServlet",
		//url : "ConsulterMuseeServlet",
		//url : "AfficherFavorisServlet",


		//data : "nom=" + iduser,
		data : "iduser=" + iduser + "&idmusee=" + idmusee,
		//data : "id=" + iduser,
		//data : "id=" + iduser,


		dataType : "json",
		success : traiteReponseEnregistrement,
		error : function(XHR, testStatus, errorThrown) 
		{
			alert(JSON.stringify(XHR + " " + testStatus + " " + errorThrown));

		}
	});
}


function traiteReponseEnregistrement(rep) 
{
	if (rep.error != undefined)  
	{
		alert("erreur:"+ rep.error);
	}
	else if (rep.message!=undefined)
	{
		alert("message:"+ rep.message);
		//alert("user :"+ rep.user)
	}
	else  
	{
		alert("ok");
	}
}