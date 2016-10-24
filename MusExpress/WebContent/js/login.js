


$(document).ready(function() 
{
	$("#login-btn").click(function()
			{
		var email = $('#email').val();
		var password = $('#password').val();
		$.post("LoginServlet",
				{ email: email, password:password},
				function(data) 
				{

					
					alert (data);
					/*var resultat = $.parseJSON(data);
					if (resultat.message=="1") 		
					{
						window.location.href = "home.html";
					}*/


				});


			});
		});


