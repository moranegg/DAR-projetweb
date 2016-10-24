<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/MusExpress/js/enregistrement.js"></script>
<script type="text/javascript" src="/MusExpress/js/jquery-3.1.1.js"></script>
<title>Inscription</title>


</head>
<body>

<form action="javascript:(function(){return;})()" method="post"
				OnSubmit="javascript:enregistrement(this)">
				

				
            <fieldset>
              
                <legend>Inscription</legend>
                
                <label for="nom">Nom </label>
                <input type="text"  id="nom" name="nom" value="" size="20" maxlength="60" required/>
                <br />
                
                <label for="prenom">Prénom </label>
                <input type="text"  id="prenom" name="prenom" value="" size="20" maxlength="60" required/>
                <br />
                
                <label for="codep">Code postal</label>
                <input type="text"  id="codep" name="codep" value="" size="20" maxlength="60" required/>
                <br />
                <label for="email">Adresse email </label>
                <input type="email"  id="email" name="email" value="" size="20" maxlength="60" required/>
                <br />
                
                <label for="password">Mot de passe</label>
                <input type="password"  id="password" name="password" value="" size="20" maxlength="20" required/>
                <br />

                <input type="submit" value="Valider"/>
                <br />
                
            </fieldset>
            
            	<div id='notifier'></div>
        </form>
</body>
</html>