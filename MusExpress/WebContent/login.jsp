<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Connexion</title>
</head>
    <body>
        <form action="LoginServlet" method="post">
				
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

        </form>

    </body>

</html>





