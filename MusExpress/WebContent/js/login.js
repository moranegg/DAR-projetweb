$(document).ready(function() 
	{
	$("#login-btn").click(function()
			{

		var email = $('#email').val();
		var password = $('#password').val();
		alert("Thank you for your comment!" + email + " " +password);
		
		//
		$.post("LoginServlet",
				{ email: email, password:password},
				function(data) 
				{

					var resultat = $.parseJSON(data);
					var user = resultat.user;
					if (resultat.message=="1") 		
					{
						//TODO: ajouter id utilisateur au path
						$(location).attr('home.html'); 
						//$(location).attr('home.html/'+user); 
					}


			});


	});
});


/*

function login(formulaire) 
{
	var email = formulaire.email.value;
	var mdp = formulaire.password.value;

	var ok = verif(email, mdp);
	if (ok) 
	{
		printHTML("#notifier","");
		connect(email, mdp);
	}

	return false;
}





function verif(email, mdp) 
{


	if(email.length==0)
	{
		func_erreur("Email manquant");
		return false;
	}

	if(mdp.length==0)
	{
		func_erreur("Mot de passe manquant");
		return false;
	}


	else 
	{
		return true;
	}
}


function connect(email, mdp) 
{
	/*$.ajax({
		type : "POST",
		url : "LoginServlet",
		data : "email=" + email+ "&password=" + mdp,
		dataType : "json",
		success : traiteReponseEnregistrement,
		error : function(XHR, testStatus, errorThrown) 
		{
			alert(XHR + "" + testStatus + "" + errorThrown);
		}
	});*/

/*	$(document).ready(function() {
        $('#form_login').ajaxForm(function() {
  alert("Thank you for your comment!");
});
});
}

function traiteReponseEnregistrement(rep) 
{
	if (rep.error != undefined)  
	{
		func_erreur(rep.error);
	}
	else if (rep.message!=undefined)
	{
		if (rep.message!="1") func_erreur(rep.message);
		else window.location.href = "home.jsp";
	}
	else 
	{
		window.location.href = "home.jsp";
	}
}


function func_erreur(msg)
{
		printHTML("#notifier",msg);
}




function printHTML(dom,htm)
{ 
	$(dom).html(htm);
}

 */
