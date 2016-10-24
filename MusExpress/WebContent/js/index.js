var index = {
 
    onReady: function() {
    },

    	
    login: function(event){
    	var email = $('#email_login').val();
		var password = $('#password_login').val();
		if(checkIsText(email)&& checkIsText(password) && isEmail(email)){
			login(email,password);
		}else{
			alert("problème !!")
		}
		
    },
    
    createAccount: function(event){
    	//alert("account");
    	var email = $('#email_register').val();
		var password = $('#password_register').val();
    	var nom = $('#nom').val();
    	var prenom = $('#prenom').val();
    	var codep = $('#codep').val();
    	

    	var ok = verif(nom, prenom, codep, email, password);
    	if (ok) {
    		console.log("ok");
    		enregistre(nom, prenom, codep, email, password);
    	}else{
    		console.log("bad!!!");
    		alert("problème !!")
    	}
    	
    }
 
};
 
$( document ).ready(function(){

		$("#login-btn").click(index.login);
		$("#register-btn").click(index.createAccount);
		
		
});


function verif(nom, prenom, codep, email, password) 
{
	
	if(prenom.length==0)
	{
		//printhtml('#notifier-register',"Prenom manquant");
		//errorElement(prenom);
		return false;
	}
	
	if(nom.length==0)
	{
		//func_erreur_inscription("Nom manquant");
		return false;
	}
	
	if(codep.length==0)
	{
		//func_erreur_inscription("Code postal manquant");
		return false;
	}
	
	if(email.length==0 && !isEmail(email))
	{
		//func_erreur_inscription("Email manquant");
		return false;
	}

	if(password.length==0)
	{
		//func_erreur_inscription("Mot de passe manquant");
		return false;
	}
	
	if(password.length<8)
	{
		//func_erreur_inscription("Mot de passe trop court");
		return false;
	}
	
	return true;
}
function login(email,password){

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
		else {
			//$(location).attr('home.html'); 
		}
	}
	else 
	{
		$(location).attr('home.html'); 
	}
}

function func_erreur_inscription(msg)
{
	printhtml('#notifier',msg);
}

function printhtml(dom,msg)
{
	$(dom).html(msg);
}

function validateElement(element){

        element.text('OK!').addClass('valid')
            .closest('.control-group').removeClass('error').addClass('success');
}

function errorElement(element){
	 var formGroup = $(element).closest('.control-group').addClass('has-error');
	 formGroup.append("<span class=\"glyphicon glyphicon-remove form-control-feedback\" aria-hidden=\"true\"></span>")
	 
}

