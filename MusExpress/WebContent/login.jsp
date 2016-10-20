<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/MusExpress/js/login.js"></script>
<script type="text/javascript" src="/MusExpress/js/jquery-3.1.1.js"></script>


<title>Connexion</title>
</head>
    <body>
			<form name="form_login" action="javascript:(function(){return;})()"
				method="post" OnSubmit="javascript:login(this)">				
            <fieldset>
            
                <legend>Connexion</legend>
                
                <label for="email">Adresse email </label>
                <input type="email"  id="email" name="email" value="" size="20" maxlength="60" />
                <br />
                
                <label for="password">Mot de passe</label>
                <input type="password"  id="password" name="password" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Connexion" />
                <br />
                
            </fieldset>
            
            	<div id='notifier'></div>
            

        </form>

    </body>

</html>





