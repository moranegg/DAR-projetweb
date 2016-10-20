function enregistrement(formulaire) 
{
	var nom = formulaire.nom.value;
	var prenom = formulaire.prenom.value;
	var codep = formulaire.codep.value;
	var email = formulaire.email.value;
	var password = formulaire.password.value;


	var ok = verif(nom, prenom, codep, email, password);
	if (ok) 
	{
		printhtml("#notifier","");
		enregistre(nom, prenom, codep, email, password);
	}
}



function verif(nom, prenom, codep, email, password) 
{
	if(prenom.length==0)
	{
		func_erreur_inscription("Prenom manquant");
		return false;
	}
	
	if(nom.length==0)
	{
		func_erreur_inscription("Nom manquant");
		return false;
	}
	
	if(codep.length==0)
	{
		func_erreur_inscription("Code postal manquant");
		return false;
	}
	
	if(email.length==0)
	{
		func_erreur_inscription("Email manquant");
		return false;
	}

	if(password.length==0)
	{
		func_erreur_inscription("Mot de passe manquant");
		return false;
	}
	
	if(password.length<8)
	{
		func_erreur_inscription("Mot de passe trop court");
		return false;
	}
	
	else 
	{
		return true;
	}
}


function enregistre(prenom, nom, codep, email, password) 
{
	$.ajax({
		type : "POST",
		url : "InscriptionServlet",
		data : "prenom=" + prenom + "&nom=" + nom + "&codep=" + codep + "&email="
				+ email+ "&password=" + password,
		dataType : "json",
		success : traiteReponseEnregistrement,
		error : function(XHR, testStatus, errorThrown) 
		{
			alert(XHR + "" + testStatus + "" + errorThrown);
		}
	});
}




function traiteReponseEnregistrement(rep) 
{
	if (rep.error != undefined)  
	{
		func_erreur_inscription(rep.error);
	}
	else if (rep.message!=undefined)
	{
		if (rep.message!="1") func_erreur_inscription(rep.message);
		else window.location.href = "home.jsp";
	}
	else 
	{
		window.location.href = "home.jsp";
	}
}

function func_erreur_inscription(msg)
{
	printhtml('#notifier',msg);
}

function printhtml(dom,htm)
{
	$(dom).html(htm);
}