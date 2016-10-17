<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta charset="utf-8">
<title>MusExpress</title>
<meta name="description" content="MusExpress">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="csrf-token" content="{{csrfToken}}">

<script type="text/javascript" src="/MusExpress/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/MusExpress/js/tether.min.js"></script>
<!--  <script type="text/javascript" src="/MusExpress/js/bootstrap.min.js"></script>-->
<script type="text/javascript" src="/MusExpress/js/login.js"></script>


<style>
body {
	padding-top: 20px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>

<<<<<<< HEAD


=======
<!-- TODO: changer les liens en local -->
>>>>>>> eb82a54ddc49cffb8a0c18c4eda86678b25b7f0d
<!-- Latest compiled and minified CSS -->
 <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
 <script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->


<!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!--[if !IE 7]>
    <style type="text/css">
        #wrap {display:table;height:100%}
    </style>
    <![endif]-->
    



</head>

<body data-spy="scroll" data-target=".subnav" data-offset="50">

	<nav class="navbar navbar-default navbar-static-top header-template"
		role="navigation" style="margin-bottom: 0">
		<div class="container">
			<div class="navbar-header">
				<h1 class="navbar-brand" >MusExpress</h1>
			</div>
		</div>
	</nav>
			
			<!-- /.navbar-header -->
<div class="container-fluid">
	<div class="row">
			<div class="col-md-6">
				<div class="panel panel-default">
                	<div class="panel-heading">
                    Formulaire de connexion
                </div>
                <div class="panel-body">
                	<div class="row">
                            <div class="col-md-10">
                              
			<form name="form_login" action="javascript:(function(){return;})()"
				method="post" OnSubmit="javascript:login(this)">	
				
				   
												<div class="form-group">
										<div class="">
											<input class="form-control login_input" id="email" placeholder="Email"
												value="" name="email" 
												data-required="true" data-notblank="true" />
												
												 <span class="help-block"></span>
										</div>

									</div>
									<div class="form-group mb20 ">
										<div class="">
											<input type="password" id="password"
												class="form-control login_input" placeholder="Mot de Passe"
												name="password" value="" data-required="true"
												data-notblank="true" data-rangelength="[5,25]"> <span
												class="help-block"></span>
										</div>
									</div>
									<div class="form-group ">
										<div class="controls">
											<input class="btn btn-success" type="submit" name="login"
												value="Connexion" id="login-btn" data-bypass />
										</div>
									</div>
									
									<div id='notifier'></div>

								

							</form>

						</div>
					</div>
					</div>
					</div>
					
					<blockquote>
  <p>La meilleure fa&ccedil;on de visiter en IDF. Chaque week-end je trouve le mus&eacute;e avec le moins d'attente et j'y vais! 
  Et je sais si je dois prendre mon parapluie...</p>
  <footer>Hugo de  <cite title="Source Title">Timeout</cite></footer>
</blockquote>
				</div>
				

        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Formulaire d'inscription
                </div>
                <div class="panel-body">
                        <div class="row">
                            <div class="col-md-10">
                              
                                <!-- form inscription-->
                                <form action="InscriptionServlet" method="post" class="form">
                                    <div class="form-group">
                                        <div class="controls">
                                            <input type="text" id="nom" name="nom" class="form-control login_input" placeholder="Nom" 
                                                   data-required="true" data-notblank="true">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="controls">
                                            <input type="text" id="prenom" name="prenom" class="form-control login_input" placeholder="Pr&eacute;nom" 
                                                   data-required="true" data-notblank="true">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="controls">
                                            <input type="text" id="codep" name="codep" class="form-control login_input" placeholder="Code Postal" 
                                                   data-required="true" data-notblank="true">

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="controls">
                                            <input type="email" id="email" name="email" class="form-control login_input" placeholder="Email" 
                                                   data-required="true" data-notblank="true" data-parsley-type="email">

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="control-group">
                                            <div class="controls">
                                                <input type="password" id="user_password" class="form-control login_input"  placeholder="Mot de passe" name="user_password"
                                                        data-required="true" data-notblank="true" data-rangelength="[5,25]">
                                                <span class="help-block"></span>
                                            </div>
                                        </div>
                                    </div>


									 <input class="btn btn-primary btn-lg" type="submit" value="Valider" onclick="test();"/>
                                   

                                </form>
                            </div><!--end col-lg-6-->
                        </div><!--end row-->
                    </div> <!--end container-- >
                </div><!--panel body-->

            </div><!--end panel-->

        </div>

    </div>
</div>


			<footer class="footer">
				<p  class="text-center">
					The source code for this application is available in <a href="https://github.com/moranegg/DAR-projetweb">this
						repository</a> on GitHub.
				</p>
			</footer>
</body>
</html>